package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {

    /**
     * Test ideal weight man.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test ideal weight woman.
     */
    @Test
    public void womanWeight() {
        Fit fin = new Fit();
        double weight = fin.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
