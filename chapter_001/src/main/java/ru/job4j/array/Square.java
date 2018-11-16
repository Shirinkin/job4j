package ru.job4j.array;


/**
 * Заполнить массив квадратами чисел
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {

    /**
     * заполняет массив через цикл элементами от 1 до bound возведенными в квадрат
     * @param bound - верхняя граница массива
     * @return массив с квадратами чисел
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
            for (int i = 0; i < rst.length; i++) {
                rst[i] = (int) Math.pow(i + 1, 2);
            }
        return rst;
    }
}