package ru.job4j.coffeemachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenBuyCoffeeFor50ThenGetSurrender10and5() {
        Machine coffeMachine = new Machine();
        int priceCoffee = 35;
        int moneyUser = 50;
        int[] result = coffeMachine.changes(moneyUser, priceCoffee);
        int[] expect = new int[]{10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBuyCoffeeFor20ButPriceCoffee35ThenThrowableException() {
        Machine coffeMachine = new Machine();
        int priceCoffee = 35;
        int moneyUser = 20;
        int[] result = coffeMachine.changes(moneyUser, priceCoffee);
        int[] expect = new int[]{moneyUser};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBuyCoffeeFor100ThenGetSurrender8Coins() {
        Machine coffeMachine = new Machine();
        int priceCoffee = 72;
        int moneyUser = 100;
        int[] result = coffeMachine.changes(moneyUser, priceCoffee);
        int[] expect = new int[]{10, 10, 5, 2, 1};
        assertThat(result, is(expect));
    }
}
