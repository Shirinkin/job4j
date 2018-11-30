package search;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("lowest", 8));
        queue.put(new Task("higher", 1));
        queue.getAll();
        Task result = queue.take();

        assertThat(result.getDesc(),is("higher"));
    }

}