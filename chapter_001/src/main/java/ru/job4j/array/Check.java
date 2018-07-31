package ru.job4j.array;

/**
 * Package for condition array.
 * Save elements boolean.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.1
 * @since 31.07.2018
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;

        for (int i = 0; i != data.length; i++) {
            if (data[i] == true) {
                result = true;
            } else {
                result = false;
                break;
            }
        }


        for (int j = 0; j != data.length; j++) {
            if (result == false) {
                if (data[j] == false) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
