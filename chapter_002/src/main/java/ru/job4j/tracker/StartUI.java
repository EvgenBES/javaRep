package ru.job4j.tracker;

import java.util.Date;

/**
 * Package for tracker.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 17.08.2018
 */

public class StartUI {

    private static final String ADD = "1";
    private static final String SHOW_ALL_ITEM = "2";
    private static final String EDIT_ITEM = "3";
    private static final String DELETE_ITEM = "4";
    private static final String FIND_ITEM_ID = "5";
    private static final String FIND_ITEM_NAME = "6";
    private static final String EXIT = "7";

    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW_ALL_ITEM:
                    System.out.println(" ");
                    System.out.println("--- Данный пункт в разработке ---");
                    System.out.println(" ");
                    break;
                case EDIT_ITEM:
                    System.out.println(" ");
                    System.out.println("--- Данный пункт в разработке ---");
                    System.out.println(" ");
                    break;
                case DELETE_ITEM:
                    System.out.println(" ");
                    System.out.println("--- Данный пункт в разработке ---");
                    System.out.println(" ");
                    break;
                case FIND_ITEM_ID:
                    System.out.println(" ");
                    System.out.println("--- Данный пункт в разработке ---");
                    System.out.println(" ");
                    break;
                case FIND_ITEM_NAME:
                    System.out.println(" ");
                    System.out.println("--- Данный пункт в разработке ---");
                    System.out.println(" ");
                    break;
                case EXIT:
                    System.out.println(" ");
                    System.out.println("--- Вы выбрали выход! Прощайте. ---");
                    System.out.println(" ");
                    exit = true;
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("----- Неверно выбран пункт меню! Попробуйте снова. -----");
                    System.out.println(" ");
                    break;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long creat = new Date().getTime();

        Item item = new Item(name, desc, creat);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        System.out.println(" ");
    }

    /**
     * Отображаемое меню.
     */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println(" 1. Add new Item");
        System.out.println(" 2. Show all items");
        System.out.println(" 3. Edit item");
        System.out.println(" 4. Delete item");
        System.out.println(" 5. Find item by Id");
        System.out.println(" 6. Find items by name");
        System.out.println(" 7. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}