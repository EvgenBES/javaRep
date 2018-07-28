package ru.job4j.loop;

/**
 * Package for loop task.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */

public class Counter {

    /**
     * Вычисляем сумму четныx чисел в диапазоне.
     *
     * @param start,finish - значения.
     * @return сумма чётных чисел.
     */

    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
