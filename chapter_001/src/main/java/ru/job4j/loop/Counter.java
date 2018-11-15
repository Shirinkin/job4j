package ru.job4j.loop;


/**
 * Counter
 *
 * @author Mikhail Shirinkin (misha.shirinkin@gmail.com)
 */
public class Counter {

    private int result;

    /**
     * Метод считает сумму четных чисел
     * @param start начало последовательности
     * @param finish конец последовательности
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        for (int elem = start; finish >= elem; elem++) {
            if (elem % 2 == 0) {
                this.result = result + elem;
            }
        }
        return result;
    }

}
