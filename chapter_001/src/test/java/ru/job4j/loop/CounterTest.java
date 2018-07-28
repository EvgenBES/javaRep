package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */

public class CounterTest {
    /**
     * Test
     */
    @Test
    public void whenStartAndFinishSum() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
