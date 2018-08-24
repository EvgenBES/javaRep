package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 22.08.2018
 */
public class ConvertList2Array {
    /**
     * @param list - лист элементов.
     * @param rows - количество элементов в строке массива.
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() / rows);
        double remainderList = list.size() % rows;
        cells = remainderList > 0 ? ++cells : cells;

        int[][] array = new int[rows][cells];
        /**
         * @param position - текущая позиция нашего списка.
         * @param return - возвращаем двух мерный массив, наполненых элементов.
         */
        int position = 0;
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != cells; j++) {
                if (list.size() != position) {
                    array[i][j] = list.get(position);
                    position++;
                }
            }
        }
        return array;
    }


    public List<Integer> convert(List<int[]> list) {
        List<Integer> listInt = new ArrayList<>();

        for (int[] ints : list) {
            for (int anInt : ints) {
                listInt.add(anInt);
            }
        }
        return listInt;
    }
}
