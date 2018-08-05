package ru.job4j.array;

/**
 * Package for condition array.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 2.07.2018
 */

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int poitArray = data.length - 1;
        for (int i = 0; i != data.length; i++) {
            if (data[0][0] != data[i][i] || data[i][poitArray] != data[poitArray][i]) {
                result = false;
                break;
            }
            poitArray--;
        }
        return result;
    }
}
//
//[0][0] [0][1] [0][2]
//[1][0] [1][1] [1][2]
//[2][0] [2][1] [2][2]