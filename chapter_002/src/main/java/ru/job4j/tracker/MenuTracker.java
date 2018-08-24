package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */


class FindItemsByName extends BaseAction {

    protected FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени заявки --------------");
        String name = input.ask("Введите имя заявки:");

        List<Item> item = tracker.findByName(name);
        if (item.size() != 0) {
            for (int i = 0; i != item.size() - 1; i++) {
                System.out.println(item.get(i).toString());
            }
        } else {
            System.out.println("------------ Заявка с данным именим не найдена --------------");
        }
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
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new Exit(6, "Exit from program", ui));
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

    private class EditItem extends BaseAction {

        protected EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменить заявку --------------");
            String id = input.ask("Введите номер заявки: ");

            if (tracker.findById(id) != null) {
                String name = input.ask("Введите новое имя заявки: ");
                String desc = input.ask("Введите новое описание заявки: ");
                long creat = new Date().getTime();

                Item item = new Item(name, desc, creat);
                tracker.replace(id, item);

                System.out.println("------------ Заявка изменина! Новые данные заявки: -----------");
                System.out.println(item.toString());
            } else {
                System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
            }
        }

    }

    private static class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите номер удаляемой заявки:");

            if (!tracker.delete(id)) {
                System.out.println("------------ Заявка норме " + id + " не найдена! -----------");
            } else {
                System.out.println("------------ Заявка норме " + id + " была удалена! -----------");
            }
        }
    }


    public List<Integer> getRange() {
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < getActionsLentgh(); i++) {
            range.add(actions.get(i).key());
        }
        return range;
    }
}