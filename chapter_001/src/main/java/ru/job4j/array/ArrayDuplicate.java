package ru.job4j.array;

import java.util.Arrays;

/**
 * Package for condition array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 2.08.2018
 */

public class ArrayDuplicate {
    /**
     * Данный метод убирает дубли из массива.
     *
     * @param array - массив слов с возможными дублями.
     * @return перезаписанный массив, без дублей.
     */

    public String[] remove(String[] array) {
        int arrayLeng = array.length;

        for (int i = 0; i < arrayLeng; i++) {
            for (int j = i + 1; j <  arrayLeng; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[arrayLeng - 1];
                    arrayLeng--;
                    j--;
                }
            }
        }

        return Arrays.copyOf(array, arrayLeng);
    }


}
