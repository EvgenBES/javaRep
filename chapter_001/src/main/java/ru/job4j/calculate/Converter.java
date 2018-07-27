package ru.job4j.calculate;

/**
 * Корвертор валюты.
 */
public class Converter {
    private double result;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return 70 / value;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return 60 / value;
    }
}
