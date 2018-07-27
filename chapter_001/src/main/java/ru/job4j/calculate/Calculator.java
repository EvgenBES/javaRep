package ru.job4j.calculate;

/**
 * Package for calculate task.
 * Class - данный класс складывает два числа, и выдаёт результат
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 27.07.2018
 */

public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public double getResult() {
        return this.result;
    }

    public void multi(double first, double second) {
        this.result = first * second;
    }
}
