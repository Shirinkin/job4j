package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    //Меню
    private final String menu = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Add new item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserShowAllItemsThenTrackerShow() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name",  "test Descr"));
        Input input = new StubInput(new String[]{"1","6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is (menu + "------------ Показаны все заявки --------------\r\n" + tracker.getAll()[0].toString() + "\r\n" + menu));
    }

    @Test
    public void whenUserFindItemByIdThenTrackerShow() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name",  "test Descr"));
        Input input = new StubInput(new String[]{"4",item.getId(),"6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is (menu + "------------ Поиск по номеру заявки --------------\r\n" + tracker.findById(item.getId()).toString() + "\r\n" + menu));
    }

    @Test
    public void whenUserFindItemByNameThenTrackerShow() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name",  "test Descr"));
        Item item2 = tracker.add(new Item("test name",  "test Descsdfr"));
        Input input = new StubInput(new String[]{"5","test name","6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findByName("test name");
        assertThat(
                new String(this.out.toByteArray()),
                is (menu + "------------ Поиск по имени заявки --------------\r\n" + tracker.findByName("test name")[0].toString() + "\r\n" + tracker.findByName("test name")[1].toString() + "\r\n" + menu));
    }

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