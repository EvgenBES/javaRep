package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 24.08.2018
 */
public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on3ArrayThenList6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when4on2ArrayThenList8() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }


    @Test
    public void when1on5ArrayThenList5() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3, 4, 5}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }


}
