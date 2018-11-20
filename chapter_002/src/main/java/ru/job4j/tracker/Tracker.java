package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

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
        this.items[this.position++] = item;
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
        for (Item item: items) {
            if (item.getId().equals(id) && item != null) {
                result = item;
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
    public void replace(String id, Item item) {
        item.setId(id);
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id) && id != null) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Удаление заявки
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index != position; index++) {
            if (id != null && this.items[index].getId().equals(id)) {
               System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                position--;
                break;
           }
       }
    }

    /**
     * Поиск заявки по имени
     * @param name - имя заявки
     * @return
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int resultPos = 0;
        for (int i = 0; i < this.position; i++) {
            if (name.equals(items[i].getName()) && this.items[i] != null) {
                result[resultPos] = this.items[i];
                resultPos++;
            }
        }
        return Arrays.copyOf(result, resultPos);
    }

    /**
     * Выводит все заявки
     * @return массив заявок заполненных
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
