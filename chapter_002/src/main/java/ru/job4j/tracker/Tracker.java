package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();


    /**
     * Рандомное айли для айтема
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Поиск заявки по айли
     * @param id
     * @return
     */
     public Item findById(String id) {
            Item result = null;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId().equals(id)) {
                    result = items.get(i);
                    break;
                }
            }
            return result;
        }

    /**
     * Редактирование заявки
     * @param id - номер заявки
     * @param item заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int index = 0; index != items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление заявки
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (id != null && this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
           }
       }
       return result;
    }

    /**
     * Поиск заявки по имени
     * @param name - имя заявки
     * @return
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (name.equals(items.get(i).getName())) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }

    /**
     * Выводит все заявки
     * @return массив заявок заполненных
     */
    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        for (int index = 0; index != items.size(); index++) {
            result.add(this.items.get(index));
        }
        return result;
    }
}
