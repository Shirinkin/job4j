package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public List<Integer> getActionsId() {
        List<Integer> range = new ArrayList<>();
        for (int index = 0; index != this.actions.size(); index++) {
            range.add(this.actions.get(index).key());
        }
        return range;
    }

    public void fillActions() {
        System.out.println("Меню.");
        this.actions.add(this.new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(this.new DeleteItem(3, "Delete item"));
        this.actions.add(this.new FindItemByID(4, "Find item by Id"));
        this.actions.add(this.new FindItemByName(5, "Find items by name"));
        this.actions.add(this.new ExitProgram(6, "Exit Program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class FindItemByID extends BaseAction {

        public FindItemByID(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.print("------------ Поиск по номеру заявки --------------");
            String number = input.ask("Введите ID заявки :");
            Item result = tracker.findById(number);
            if (result == null) {
                System.out.print("Нет такой заявки");
            } else {
                System.out.print(result.toString());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------" + "\n");
        }

    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }
    }

    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.print("------------ Поиск по имени заявки --------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> result = tracker.findByName(name);
            for (int index = 0; index != result.size(); index++) {
                System.out.print(result.get(index).toString());
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ заявка с Id : " + id + " успешно удалена" + "\n");
            } else {
                System.out.println("Нет такой заявки!" + "\n");
            }
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.print("------------ Показаны все заявки --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(item.toString());
            }
        }
    }

}

class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите id заявки :");
        String name = input.ask("Отредактируйте имя заявки :");
        String desc = input.ask("Отредактируйте описание заявки :");
        tracker.replace(id, new Item(name, desc));
        System.out.println("------------ заявка с getId : " + id + " успешно отредактирована" + "\n");
    }

}


