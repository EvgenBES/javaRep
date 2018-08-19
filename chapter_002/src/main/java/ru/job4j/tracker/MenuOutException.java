package ru.job4j.tracker;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
