package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

import static org.junit.Assert.assertThat;

/**
 * Тестируем класс ArrayDuplicate
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"mike", "mike", "lol"};
        String[] except = {"mike", "lol"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateSecondTry() {
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] input = new String[] {"1", "1", "2", "3", "4", "4", "5", "5"};
        String[] result = new String[] {"1", "2", "3", "4", "5"};
        input = dupl.remove(input);
        assertThat(input, arrayContainingInAnyOrder(result));
    }
}