package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(600);
        assertThat(result, is(10));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(770);
        assertThat(result, is(11));
    }

    @Test
    public void when2DollarToRubleThen1() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(2);
        assertThat(result, is(120));
    }

    @Test
    public void when2EuroToRubleThen1() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(5);
        assertThat(result, is(350));
    }
}