package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = tracker.getAll().get(0);
        assertThat(item1, is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindByNameThenTrackerGivesItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test1", "testDescrisdfption", 1234L);
        tracker.add(item2);
        List<Item> result = tracker.findByName("test1");
        assertThat(tracker.findByName("test1"), is(result));
    }

    @Test
    public void whenGetAllThenTrackerGivesAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenDeleteFirstItemThenTrackerHaveOnlySecondItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test123", "testDescription23", 1234L);
        tracker.add(item2);
        tracker.delete(item1.getId());
        List<Item> expected = new ArrayList<>();
        expected.add(item2);
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenDeleteItemWithId458ItemThenFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test123", "testDescription23", 1234L);
        tracker.add(item2);
        boolean result = tracker.delete("458");
        assertThat(result, is(false));
    }


}