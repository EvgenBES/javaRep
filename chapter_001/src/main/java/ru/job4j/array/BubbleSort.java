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


/**

 boolean position = true;
 int temp;

     while (position) {
         position = false;

         for (int i = 0; i != array.length - 1; i++) {
                 if (array[i] > array[i + 1]) {
                 temp = array[i];
                 array[i] = array[i + 1];
                 array[i + 1] = temp;
                 position = true;
             }
         }
     }
 */


        for (int i = 0; i < array.length; i++) {
            int numb = array[i];

            for (int j = i - 1; j >= 0; j--) {
                int leftNumb = array[j];
                if (numb < leftNumb) {
                    array[j + 1] = leftNumb;
                    array[j] = numb;
                } else {
                    break;
                }
            }
        }

        return array;
    }
}
