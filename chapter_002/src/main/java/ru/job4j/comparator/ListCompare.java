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
        int checkLength = Integer.compare(left.length(), right.length());

        for (int i = 0; i < left.length(); i++) {
            if (result == 0) {
                if (i < right.length()) {
                    result = Character.compare(left.charAt(i), right.charAt(i));
                } else {
                    result = checkLength;
                }
            } else {
                break;
            }
        }
        return result == 0 ? checkLength : result;
    }
}
