package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявок
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявок по айди
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для показа заявок по айди
     */
    private static final String SHOWBYID = "4";

    /**
     * Константа меню для показа заявок по имени
     */
    private static final String SHOWBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (SHOWBYID.equals(answer)) {
                this.showItemByID();
            } else if (SHOWBYNAME.equals(answer)) {
                this.showItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует поиск заявки по имени
     */
    private void showItemByName() {
        System.out.println("------------ Поиск по имени заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] item = this.tracker.findByName(name);
        for (int index = 0; index != item.length; index++) {
            System.out.println(item[index].toString());
        }
    }

    /**
     *Метод реализует редактирование заявки по айди
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = new Item(null,null);
        if (this.tracker.replace(id,item)) {
            String name = this.input.ask("Отредактируйте имя заявки :");
            String desc = this.input.ask("Отредактируйте описание заявки :");
            item = new Item(name, desc);
            this.tracker.replace(id, item);
            System.out.println("------------ заявка с getId : " + item.getId() + " успешно отредактирована" + "\n");
        } else {
            System.out.println("Нет такой заявки!" + "\n");
        }
    }

    /**
     *Метод реализует удаление заявки по айди
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ заявка с Id : " + id + " успешно удалена" + "\n");
        } else {
            System.out.println("Нет такой заявки!" + "\n");
        }
    }


    /**
     * Метод реализует добавлене новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------" + "\n");
    }

    /**
     * Метод реализует показ заявки по айди
     */
    private void showItemByID() {
        System.out.println("------------ Поиск по номеру заявки --------------");
        String number = this.input.ask("Введите ID заявки :");
        Item result = tracker.findById(number);
        if (result == null) {
            System.out.println("Нет такой заявки");
        } else {
            System.out.println(result.toString());
        }
    }

    /**
     * Метод реализует показ всех заявок
     */
    private void showAllItems() {
        System.out.println("------------ Показаны все заявки --------------");
        Item[] item = this.tracker.getAll();
        for (int index = 0; index != item.length; index++) {
            System.out.println(item[index].toString());
        }
    }

    /**
     * Показывает меню
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}