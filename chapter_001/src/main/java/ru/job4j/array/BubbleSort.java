package ru.job4j.array;

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
     * @param array подаваемый массив.
     * @return отсортированный массив от малого до максимального числа.
     */

    public int[] sort(int[] array) {
        boolean position = false;

        do {
            for (int i = 0; i != array.length - 1; i++) {
                int temp;
                int steep = i + 1;
                position = true;
                if (array[i] > array[steep]) {
                    temp = array[i];
                    array[i] = array[steep];
                    array[steep] = temp;
                    position = false;
                    break;
                }
            }

        } while (!position);

        return array;
    }

}
