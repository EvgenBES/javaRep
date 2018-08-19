package ru.job4j.tracker;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class FindItemById implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите номер заявки:");

        Item item = tracker.findById(id);
        System.out.println(item.toString());
    }

    @Override
    public String info() {
        return " 5. Find item by Id";
    }
}
