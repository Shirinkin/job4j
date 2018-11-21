package ru.job4j.tracker;

/**
 * Интерфейс группирует действия пользователя
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции
     * @return ключ
     */
    int key();

    /**
     * Основной метод
     * @param input оъект типа Input
     * @param tracker обьект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню
     * @return сообщение (строка меню)
     */
    String info();

}
