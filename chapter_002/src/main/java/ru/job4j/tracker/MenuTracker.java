package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private int position = 0;
    private UserAction[] actions = new UserAction[8];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] getActionsId(){
        int[] range = new int[7];
        for (int index = 0; index != range.length; index++) {
            range[index] = index;
        }
        return range;
    }

    public void fillActions() {
        System.out.println("Меню.");
        this.actions[position++] = this.new AddItem(0,"Add new item");
        this.actions[position++] = new MenuTracker.ShowItems(1,"Show all items");
        this.actions[position++] = new EditItem(2,"Edit item");
        this.actions[position++] = this.new DeleteItem(3,"Delete item");
        this.actions[position++] = this.new FindItemByID(4,"Find item by Id");
        this.actions[position++] = this.new FindItemByName(5,"Find items by name");
        this.actions[position++] = this.new ExitProgram(6,"Exit Program");
    }

    public void select(int key) {
        this.actions[key].execute(this.input,tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class FindItemByID extends BaseAction {

        public FindItemByID(int key,String name) {
            super(key,name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск по номеру заявки --------------");
            String number = input.ask("Введите ID заявки :");
            Item result = tracker.findById(number);
            if (result == null) {
                System.out.println("Нет такой заявки");
            } else {
                System.out.println(result.toString());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key,String name) {
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
            super(key,name);
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
            System.out.println("------------ Поиск по имени заявки --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] item = tracker.findByName(name);
            for (int index = 0; index != item.length; index++) {
                System.out.println(item[index].toString());
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
            System.out.println("------------ Показаны все заявки --------------");
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
        tracker.replace(id,new Item(name, desc));
        System.out.println("------------ заявка с getId : " + id + " успешно отредактирована" + "\n");
    }

}


