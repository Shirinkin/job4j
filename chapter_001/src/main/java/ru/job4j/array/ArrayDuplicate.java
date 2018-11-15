package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаляет дубликаты из массива
 */
public class ArrayDuplicate {

    /**
     * Удаление одинаовых строк в массиве
     * @param array - массив строк
     * @return массив строк с уделенными одинаковыми значениями
     */
    String[] remove(String[] array) {
        //кол-во одинаковых записей
        int last = array.length;
        for (int i = 0; i < last; i++) {
            for (int j = i + 1; j < last; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[last - 1];
                    last--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, last);
    }
}
