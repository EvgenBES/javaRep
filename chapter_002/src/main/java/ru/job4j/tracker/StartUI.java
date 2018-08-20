package ru.job4j.tracker;

/**
 * Package for tracker.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 17.08.2018
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("select:", menu.getRange()));
        } while (this.working);
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    public void stop() {
        this.working = false;
    }
}


