package ru.job4j.loop;

/**
 * Package for loop task.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */


public class Factorial {

    /**
     * Вычисление факториала.
     *
     * @param n - значения.
     * @return факториал.
     */

    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
