package ru.job4j.coffeemachine;

import java.util.Arrays;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 10.09.2018
 */

public class Machine {
    private int[] listCoins = new int[]{10, 5, 2, 1};

    /**
     * Coffee machine.
     * @param value - money user;
     * @param price - price coffee;
     * @return if true - get surrender coins else false - get back user money;
     */

    public int[] changes(int value, int price) {
        int surrender = value - price;

        if (value > price) {
            int[] retCoins = new int[surrender];
            int position = 0;

            while (surrender != 0) {
                for (int i = 0; i != listCoins.length; i++) {
                    if (listCoins[i] <= surrender) {
                        retCoins[position] = listCoins[i];
                        position++;
                        surrender -= listCoins[i];
                        break;
                    }
                }
            }

            return Arrays.copyOfRange(retCoins, 0, position);

        } else {
            return new int[]{value};
        }
    }
}
