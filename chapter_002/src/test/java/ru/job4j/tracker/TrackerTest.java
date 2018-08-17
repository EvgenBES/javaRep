package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrackerNoDeletedItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 124L);
        Item third = new Item("test3", "testDescription3", 125L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        second.setId("testId2244");
        tracker.delete("testId2244");
        int resul = tracker.getAll().length;
        assertThat(resul, is(2));
    }

    @Test
    public void whenFindByNameThenReturnNewArrayItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 124L);
        Item third = new Item("test2", "testDescription3", 125L);
        Item fourth = new Item("test3", "testDescription4", 126L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        Item[] result = tracker.findByName("test2");
        assertThat(result.length, is(2));
    }
}