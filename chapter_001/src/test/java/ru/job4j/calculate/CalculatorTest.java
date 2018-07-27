package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.1
 * @since 27.07.2018
 */
public class CalculatorTest {
    /**
     * Test result.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test multi.
     */
    @Test
    public void whenMult2On2Then1() {
        Calculator calc = new Calculator();
        calc.multi(3D, 2D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    /**
     * Test Divide.
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        calc.divide(3D, 3D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test Subtraction.
     */
    @Test
    public void whenSub2On2Then1() {
        Calculator calc = new Calculator();
        calc.subtraction(10D, 5D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

}