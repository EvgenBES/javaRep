package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
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
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 1239594));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 1239594));

        Input input = new StubInput(new String[]{
                "0",                     //Main menu: "0. Add new Item"
                "ItemName1",             //Add menu: "Введите имя заявки :"
                "Desc1",                 //Add menu: "Введите описание заявки :"

                "0",                     //Main menu: "0. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки :"
                "Desc2",                 //Add menu: "Введите описание заявки :"

                "3",                     //Main menu: "3. Delete item");
                item.getId(),            //Add menu: "Введите номер удаляемой заявки:"
                "6"                      //Main menu: "6. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item[] res = tracker.getAll();
        assertThat(res.length, is(2));
    }


    @Test
    public void whenShowAllItemThenTrackerHasQuantityItemValue() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(new String[]{
                "0",                     //Main menu: "0. Add new Item"
                "ItemName1",             //Add menu: "Введите имя заявки :"
                "Desc1",                 //Add menu: "Введите описание заявки :"

                "0",                     //Main menu: "0. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки :"
                "Desc2",                 //Add menu: "Введите описание заявки :"

                "0",                     //Main menu: "0. Add new Item"
                "ItemName3",             //Add menu: "Введите имя заявки :"
                "Desc3",                 //Add menu: "Введите описание заявки :"
                "6"                      //Main menu: "6. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item[] res = tracker.getAll();
        assertThat(res.length, is(3));
    }


    @Test
    public void whenFindByItemIdThenTrackerHasItemValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("ItemName99", "desc", 1239594));
        item.setId("123456799");

        Input input = new StubInput(new String[]{
                "0",                     //Main menu: "0. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки:"
                "Desc4",                 //Add menu: "Введите описание заявки:"

                "4",                     //Main menu: "4. Find item by Id"
                item.getId(),            //Add menu: "Введите номер заявки:"
                "6"                      //Main menu: "6. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item res = tracker.findById(item.getId());
        assertThat(res.getName(), is("ItemName99"));
    }


    @Test
    public void whenFindByItemNameThenTrackerHasItemValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("ItemName99", "desc", 1239594));

        Input input = new StubInput(new String[]{
                "0",                     //Main menu: "0. Add new Item"
                "ItemName2",             //Add menu: "Введите имя заявки:"
                "Desc4",                 //Add menu: "Введите описание заявки:"

                "5",                     //Main menu: "4. Find item by Id"
                item.getName(),          //Add menu: "Введите имя заявки:"
                "6"                      //Main menu: "6. Exit Program");
        });

        new StartUI(input, tracker).init();
        Item[] res = tracker.findByName("ItemName99");
        assertThat(res.length, is(1));
    }


    @Test
    public void whenChoseShowMenuThenSawAllMenu() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Add new Item")
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
                                .append("6. Exit from program")
                                .append(System.lineSeparator())
                                .append("Вы выбрали Exit. До новых встреч!")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
