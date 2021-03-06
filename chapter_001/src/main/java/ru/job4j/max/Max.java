package ru.job4j.max;

/**
 * Package for max task.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */

public class Max {
    /**
     * Опеределние максимального числа.
     *
     * @param first,second - значения.
     * @return максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Опеределние максимального числа.
     *
     * @param first,second,third - значения.
     * @return максимальное число.
     */
    public int maxThird(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
