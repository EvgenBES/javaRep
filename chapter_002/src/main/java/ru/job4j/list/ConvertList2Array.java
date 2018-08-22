package ru.job4j.list;

import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 22.08.2018
 */
public class ConvertList2Array {

    /**
     * метод toArray должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк
     * - оставшиеся значения в массиве заполнять нулями.
     *
     * @param list - лист элементов.
     * @param rows - количество элементов в строке массива.
     * @return
     */

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() / rows);
        double remainderList = list.size() % rows;

        /**
         * Прорка остатка, если он больше 0, тогда добавляет еще одну строку в массив.
         * В противном случае оставляем без изменений.
         */
        if (remainderList > 0) {
            cells++;
        }

        int[][] array = new int[rows][cells];

        /**
         * @param position - текущая позиция нашего списка, наполнение списка происходит до тех пор
         *  пока не будет позиция не станет равна размеру подаваемого списка.
         *
         *  Дальше используем наполнение массива через цикл наполнения двух мерного массива.
         *
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
}
