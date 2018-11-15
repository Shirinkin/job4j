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
        String [] input = {"mike","mike","lol"};
        String [] except = {"mike", "lol"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String [] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}