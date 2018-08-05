package ru.job4j.array;

/**
 * Package for condition array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 2.07.2018
 */

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int i = 0; i != size; i++) {
            for (int j = 0; j != size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}