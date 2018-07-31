package ru.job4j.array;

/**
 * Package for condition array.
 * Save elements boolean.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 31.07.2018
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;

        for (int i = 0; i != data.length; i++) {
            if (data[i] == true) {
                if (i == data.length - 1) {
                    result = true;
                }
            } else {
                break;
            }
        }

        for (int i = 0; i != data.length; i++) {
            if (data[i] == false) {
                if (i == data.length - 1) {
                    result = true;
                }
            } else {
                break;
            }
        }

        return result;
    }
}
