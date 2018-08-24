package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.action.BaseAction;

import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> allItem = tracker.getAll();
        System.out.println("------------ Список всех заявок --------------");
        showAllFindItem(allItem);
    }

    private void showAllFindItem(List<Item> item) {
        for (Item item1 : item) {
            System.out.println(item1.toString());
        }
    }
}
