package ru.job4j.array;

/**
 * Package for condition array.
 * Add int to array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 31.07.2018
 */

public class Square {
    /**
     * Заполнить массив степенями чисел.
     *
     * @param bound размер массива.
     * @return массив с числами возведённые в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != rst.length; i++) {
            double a = 2;
            double b = 1 + i;
            rst[i] = (int) Math.pow(b, a);
        }
        return rst;
    }
}
