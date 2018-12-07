package ru.job4j.tracker;

import java.util.List;

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

        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show(System.out::println);
            //int key = Integer.valueOf(this.input.ask("Select:"));
            menu.select(input.ask("Select:", menu.getActionsId()));
        } while (!"y".equals(this.input.ask("Exit? (y)")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}