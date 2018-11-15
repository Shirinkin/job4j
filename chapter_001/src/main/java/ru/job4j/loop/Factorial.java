package ru.job4j.loop;


/**
 * Counter
 *
 * @author Mikhail Shirinkin (misha.shirinkin@gmail.com)
 */
public class Factorial {

    private int result = 1;
    /**
     * Метод считает факториал числа
     * @param n Число, факториал которого надо посчитать
     * @return факториал числа
     */
    public int calc(int n) {
        for (int index = 1; index <= n; index++) {
            result = result * index;
        }
        return result;
    }
}
