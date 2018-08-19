package ru.job4j.tracker;

import java.util.Date;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class AddItem implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        long creat = new Date().getTime();

        Item item = new Item(name, desc, creat);
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        System.out.println("New Item with Name: " + item.getName());
        System.out.println("New Item with Description: " + item.getDescription());
        System.out.println(" ");
    }

    @Override
    public String info() {
        return " 1. Add new Item.";
    }

}
