package ru.job4j.array;

/**
 * Package for condition array.
 * Revolution the array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 31.07.2018
 */

public class Turn {
    /**
     * Метод вызвает переворот массива, когда конец уходит в перёд, а начало в конец.
     *
     * @param array - массив с числами
     * @return перевёрнутый массив.
     */
    public int[] turn(int[] array) {
        for (int i = 0; i != array.length / 2; i++) {
            int tempItem = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tempItem;
        }
        return array;
    }
}
