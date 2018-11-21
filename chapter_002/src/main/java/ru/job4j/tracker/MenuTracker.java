package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }



    public void fillActions() {
        System.out.println("Меню.");
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemByID();
        this.actions[5] = this.new FindItemByName();
        this.actions[6] = this.new ExitProgram();
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

    private class FindItemByID implements UserAction {

        @Override
        public int key(){
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key(){
            return 0;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    private class ExitProgram implements UserAction {

        @Override
        public int key(){
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }

    private class FindItemByName implements UserAction {

        @Override
        public int key(){
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    private class DeleteItem implements UserAction {


        @Override
        public int key(){
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key(){
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Показаны все заявки --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(item.toString());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

}

class EditItem implements UserAction {

    @Override
    public int key(){
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите id заявки :");
        Item item = new Item(null,null);
        if (tracker.replace(id,item)) {
            String name = input.ask("Отредактируйте имя заявки :");
            String desc = input.ask("Отредактируйте описание заявки :");
            item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("------------ заявка с getId : " + item.getId() + " успешно отредактирована" + "\n");
        } else {
            System.out.println("Нет такой заявки!" + "\n");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}
