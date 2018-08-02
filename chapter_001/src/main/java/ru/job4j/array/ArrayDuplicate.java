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
    public String[] remove(String[] array) {
        int arrLeng = array.length;

        for (int i = 0; i < arrLeng; i++) {
            for (int j = i + 1; j <  arrLeng; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[arrLeng - 1];
                    arrLeng--;
                    j--;
                }
            }
        }

        return Arrays.copyOf(array, arrLeng);
    }


}
