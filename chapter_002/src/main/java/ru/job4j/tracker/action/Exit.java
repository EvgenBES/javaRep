package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.action.BaseAction;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 20.08.2018
 */
public class Exit extends BaseAction {
    private final StartUI ui;

    public Exit(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }



    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Вы выбрали Exit. До новых встреч!");
        this.ui.stop();
    }
}
