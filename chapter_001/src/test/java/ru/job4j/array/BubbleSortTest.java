package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] expect = bubble.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5, 6, 9});
        int[] rst = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        assertThat(rst, is(expect));
    }
}