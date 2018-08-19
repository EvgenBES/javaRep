package ru.job4j.tracker;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class ShowItems implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] allItem = tracker.getAll();
        System.out.println("------------ Список всех заявок --------------");
        showAllFindItem(allItem);
    }

    @Override
    public String info() {
        return " 2. Show all items";
    }

    private void showAllFindItem(Item[] item) {
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }
    }
}
