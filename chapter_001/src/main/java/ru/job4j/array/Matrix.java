package ru.job4j.array;

/**
 * Таблица умножения
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {

    /**
     * Метод генерирует таблицу умножения
     * @param size - размер таблицы
     * @return таблица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                table[i][k] = (i + 1) * (k + 1);
            }
        }
        return table;
    }

}
