package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 25.08.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        for (int i = 0; i != left.length(); i++) {
            if (right.length() >= i && left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            } else if (right.length() >= i && left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            } else if (right.length() > left.length()) {
                result = -1;
            }
        }
        return result;
    }
}
