package ru.job4j.array;

import java.util.Arrays;

/**
 * Package for condition array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 1.08.2018
 */

public class BubbleSort {
    /**
     * Метод сортировки чисел от маленького до большого.
     *
     * @param array подаваемый массив.
     * @return отсортированный массив от малого до максимального числа.
     */

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];

            for (int j = i - 1; j >= 0; j--) {
                int leftNumb = array[j];
                if (temp < leftNumb) {
                    array[j + 1] = leftNumb;
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
