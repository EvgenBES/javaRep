package ru.job4j.labmda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 10.09.2018
 */
public class Calculator {

    public interface Operation {
        double calc(int left, int right);
    }

    public void multiple(int start, int finish, int value, Operation op) {
        for (int index = start; index != finish; index++) {
            System.out.println(op.calc(value, index));
        }
    }


    public List<Double> diapason(int start, int end, BiFunction<Double, Double, Double> func) {
        List<Double> result = new ArrayList<>();



        return result;
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(0, 10, 2, new Operation() {
            @Override
            public double calc(int left, int right) {
                return left * right;
            }
        });
    }
}
