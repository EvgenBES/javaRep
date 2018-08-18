package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"1", "test name", "desc", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc", 1239594));
        Input input = new StubInput(new String[]{"3", item.getId(), "test replace", "заменили заявку", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasDeletedValue() {
        boolean result;

        Item item = tracker.add(new Item("test name", "desc", 1239594));

        Input input = new StubInput(new String[]{
                "1",                     //Main menu: "1. Add new Item"
                "ItemName1",             //Add menu: "Введите имя заявки :"
                "Desc1",                 //Add menu: "Введите описание заявки :"

                "1",                     //Main menu: "1. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки :"
                "Desc2",                 //Add menu: "Введите описание заявки :"

                "4",                     //Main menu: "4. Delete item");
                item.getId(),            //Add menu: "Введите номер удаляемой заявки:"
                "7"                      //Main menu: "7. Exit Program");
        });

        new StartUI(input, tracker).init();

        Item[] res = tracker.getAll();

        if (res.length == 2) {
            result = true;
        } else {
            result = false;
        }

        assertThat(true, is(result));
    }


    @Test
    public void whenShowAllItemThenTrackerHasQuantityItemValue() {
        boolean result;

        Input input = new StubInput(new String[]{
                "1",                     //Main menu: "1. Add new Item"
                "ItemName1",             //Add menu: "Введите имя заявки :"
                "Desc1",                 //Add menu: "Введите описание заявки :"

                "1",                     //Main menu: "1. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки :"
                "Desc2",                 //Add menu: "Введите описание заявки :"

                "1",                     //Main menu: "1. Add new Item"
                "ItemName3",             //Add menu: "Введите имя заявки :"
                "Desc3",                 //Add menu: "Введите описание заявки :"
                "7"                      //Main menu: "7. Exit Program");
        });

        new StartUI(input, tracker).init();

        Item[] res = tracker.getAll();

        if (res.length == 3) {
            result = true;
        } else {
            result = false;
        }

        assertThat(true, is(result));
    }


    @Test
    public void whenFindByItemIdThenTrackerHasItemValue() {
        Item item = tracker.add(new Item("ItemName99", "desc", 1239594));
        item.setId("123456799");

        Input input = new StubInput(new String[]{
                "1",                     //Main menu: "1. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки:"
                "Desc4",                 //Add menu: "Введите описание заявки:"

                "5",                     //Main menu: "5. Find item by Id"
                item.getId(),            //Add menu: "Введите номер заявки:"
                "7"                      //Main menu: "7. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item res = tracker.findById(item.getId());

        assertThat(res.getName(), is("ItemName99"));
    }


    @Test
    public void whenFindByItemNameThenTrackerHasItemValue() {
        Item item = tracker.add(new Item("ItemName99", "desc", 1239594));

        Input input = new StubInput(new String[]{
                "1",                     //Main menu: "1. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки:"
                "Desc4",                 //Add menu: "Введите описание заявки:"

                "6",                     //Main menu: "5. Find item by Id"
                item.getName(),          //Add menu: "Введите имя заявки:"
                "7"                      //Main menu: "7. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item[] res = tracker.findByName("ItemName99");

        assertThat(res.length, is(1));
    }


    @Test
    public void whenChoseShowMenuThenSawAllMenu() {
        Input input = new StubInput(new String[]{"7"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню:")
                                .append(System.lineSeparator())
                                .append(" 1. Add new Item")
                                .append(System.lineSeparator())
                                .append(" 2. Show all items")
                                .append(System.lineSeparator())
                                .append(" 3. Edit item")
                                .append(System.lineSeparator())
                                .append(" 4. Delete item")
                                .append(System.lineSeparator())
                                .append(" 5. Find item by Id")
                                .append(System.lineSeparator())
                                .append(" 6. Find items by name")
                                .append(System.lineSeparator())
                                .append(" 7. Exit Program")
                                .append(System.lineSeparator())
                                .append(" ")
                                .append(System.lineSeparator())
                                .append("--- Вы выбрали выход! Прощайте. ---")
                                .append(System.lineSeparator())
                                .append(" ")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}
