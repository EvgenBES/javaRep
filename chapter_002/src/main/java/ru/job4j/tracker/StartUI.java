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
                    System.out.println(" ");
                    this.createItem();
                    break;
                case SHOW_ALL_ITEM:
                    System.out.println(" ");
                    this.showAllItem();
                    break;
                case EDIT_ITEM:
                    System.out.println(" ");
                    editItem();
                    System.out.println(" ");
                    break;
                case DELETE_ITEM:
                    System.out.println(" ");
                    deleteItem();
                    System.out.println(" ");
                    break;
                case FIND_ITEM_ID:
                    System.out.println(" ");
                    findByItemId();
                    System.out.println(" ");
                    break;
                case FIND_ITEM_NAME:
                    System.out.println(" ");
                    findByItemName();
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
     * Метод отображения всех заявок.
     */
    private void showAllItem() {
        Item[] allItem = this.tracker.getAll();
        System.out.println("------------ Список всех заявок --------------");
        showAllFindItem(allItem);
    }

    /**
     * Метод изменения заявки.
     */
    private void editItem() {
        System.out.println("------------ Изменить заявку --------------");
        String id = this.input.ask("Введите номер заявки: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        long creat = new Date().getTime();

        Item item = new Item(name, desc, creat);

        if (this.tracker.replace(id, item)) {
            System.out.println(" ");
            System.out.println("------------ Заявка изменина! Новые данные заявки: -----------");
            System.out.println(item.toString());
        } else {
            System.out.println(" ");
            System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
            System.out.println(" ");
        }
    }

    /**
     * Метод удаление заявки по ID.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите номер удаляемой заявки:");

        if (this.tracker.delete(id)) {
            System.out.println(" ");
            System.out.println("------------ Заявка норме " + id + " была удалена! -----------");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
            System.out.println(" ");
        }

    }


    /**
     * Метод поиска заявки по ID.
     */
    private void findByItemId() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите номер заявки:");

        Item item = this.tracker.findById(id);
        System.out.println(item.toString());
    }

    /**
     * Метод поиска заявки по Name.
     */
    private void findByItemName() {
        System.out.println("------------ Поиск заявки по имени заявки --------------");
        String name = this.input.ask("Введите имя заявки:");

        Item[] item = this.tracker.findByName(name);
        showAllFindItem(item);
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
     * Метод отображение массива найденных заявок
     *
     * @param item массив заявок
     */
    private void showAllFindItem(Item[] item) {
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }
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


