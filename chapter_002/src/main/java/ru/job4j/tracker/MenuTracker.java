package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */


class FindItemsByName implements UserAction {

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени заявки --------------");
        String name = input.ask("Введите имя заявки:");

        Item[] item = tracker.findByName(name);
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }
    }

    @Override
    public String info() {
        return " 6. Find items by name";
    }
}


public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
    }


    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class EditItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменить заявку --------------");
            String id = input.ask("Введите номер заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            long creat = new Date().getTime();

            Item item = new Item(name, desc, creat);

            if (tracker.replace(id, item)) {
                System.out.println(" ");
                System.out.println("------------ Заявка изменина! Новые данные заявки: -----------");
                System.out.println(item.toString());
            } else {
                System.out.println(" ");
                System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
                System.out.println(" ");
            }
        }

        @Override
        public String info() {
            return " 3. Edit item";
        }
    }

    private static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите номер удаляемой заявки:");

            if (tracker.delete(id)) {
                System.out.println(" ");
                System.out.println("------------ Заявка норме " + id + " была удалена! -----------");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
                System.out.println(" ");
            }
        }

        @Override
        public String info() {
            return " 4. Delete item";
        }
    }
}