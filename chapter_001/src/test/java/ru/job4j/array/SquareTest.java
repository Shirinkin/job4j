package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Square Class
 *
 * @author Misha Shirinkin (misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {

    /**
     * Вводим три получаем последовательность 1 4 9
     * Тестируем метод square класса Square
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Вводим четыре получаем последовательность 1 4 9 16
     * Тестируем метод square класса Square
     */
    @Test
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

    /**
     * Вводим 0 получаем последовательность 0
     * Тестируем метод square класса Square
     */
    @Test
    public void whenBound0Then0() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {};
        assertThat(rst, is(expect));
    }
}
