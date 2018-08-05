package ru.job4j.array;

/**
 * Package for condition array.
 * Return index Array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 31.07.2018
 */

public class FindLoop {
    /**
     * Заполнить массив степенями чисел.
     *
     * @param el значение которое ищем.
     * @return индекс расположения элемента в массиве.
     */

    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }


}