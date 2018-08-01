package ru.job4j.array;

/**
 * Package for condition array.
 * Save elements boolean.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.2
 * @since 31.07.2018
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;

        for (int i = 0; i != data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
