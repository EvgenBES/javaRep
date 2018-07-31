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


public class TurnTest {
    @Test
    public void whenExpectTurnRst() {
        Turn turn = new Turn();
        int[] expect = turn.turn(new int[]{1, 2, 3, 4, 5});
        int[] rst = new int[]{5, 4, 3, 2, 1};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
