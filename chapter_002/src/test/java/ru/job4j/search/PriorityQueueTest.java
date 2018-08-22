package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.12
 * @since 22.08.2018
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgentPlus", 2));
        queue.put(new Task("middlePlus", 4));
        queue.put(new Task("very big", 6));
        Task result = queue.task();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenOnePosition() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("very big", 6));
        queue.put(new Task("very big", 6));
        queue.put(new Task("very big", 6));
        queue.put(new Task("very big", 6));
        queue.put(new Task("very big", 6));
        Task result = queue.task();
        assertThat(result.getDesc(), is("very big"));
    }

    @Test
    public void whenRandomPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent2", 1));
        queue.put(new Task("urgentPlus", 2));
        queue.put(new Task("low2", 5));
        queue.put(new Task("very big", 6));
        queue.put(new Task("middlePlus", 4));
        queue.put(new Task("zero", 0));
        queue.put(new Task("middle2", 3));
        Task result = queue.task();
        assertThat(result.getDesc(), is("zero"));
    }
}
