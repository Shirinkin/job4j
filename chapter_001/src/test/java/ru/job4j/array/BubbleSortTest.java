package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    /**
     * Проверяет метод sort, отсортируется ли последовательность
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[] {1, 2, 4, 6};
        assertThat(result, Matchers.is(expect));
    }

    /**
     * Проверяет метод sort, отсортируется ли последовательность 2
     */
    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {

        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, Matchers.is(expect));
    }
}
