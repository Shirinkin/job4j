package ru.job4j.array;

/**
 * Классический поиск перебором
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {

    /**
     * Возвращает индекс элемента, оторый подходит под условие
     * @param data - массив
     * @param el - индекс элемента
     * @return индекс искомого элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
