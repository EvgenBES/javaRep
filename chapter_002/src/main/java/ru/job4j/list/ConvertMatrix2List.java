package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 24.08.2018
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i != array.length; i++) {
            for (int j = 0; j != array[0].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
