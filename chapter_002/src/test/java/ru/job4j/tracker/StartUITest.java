package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

   @Test
    public void whenDeleteItemThenNoMatchFound() {
       // создаём Tracker
       Tracker tracker = new Tracker();
       //Напрямую добавляем заявки
       Item item1 = tracker.add(new Item("test name", "desc"));
       Item item2 = tracker.add(new Item("test123", "desc"));
       Item item3 = tracker.add(new Item("test", "de54564sc"));
       Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
       new StartUI(input, tracker).init();
       assertThat(tracker.getAll()[1].getName(), is("test"));
          }
}