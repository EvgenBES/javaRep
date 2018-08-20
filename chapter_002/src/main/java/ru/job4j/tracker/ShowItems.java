package ru.job4j.tracker;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class ShowItems extends BaseAction {

    protected ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] allItem = tracker.getAll();
        System.out.println("------------ Список всех заявок --------------");
        showAllFindItem(allItem);
    }

    private void showAllFindItem(Item[] item) {
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }
    }
}
