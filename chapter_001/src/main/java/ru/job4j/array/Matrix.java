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

        for (int i = 0; i != size ; i++) {
            int numb1;
            int numb2 = 1 + i;
            for (int j = 0; j != size ; j++) {
                numb1 = 1 + j;
                table[i][j] = numb1 * numb2;
            }
        }
        return table;
    }
}