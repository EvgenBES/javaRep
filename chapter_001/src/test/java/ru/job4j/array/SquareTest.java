package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 31.07.2018
 */

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenPositionArrayAIsPositionArrayB() {
        int bound = 3;
        int positionA = 2;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int positionB = 9;
        assertThat(rst[positionA], is(positionB));
    }
}
