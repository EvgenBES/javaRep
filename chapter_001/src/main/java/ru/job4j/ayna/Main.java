package ru.job4j.ayna;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 20.01.2019
 */
public class Main {
    int a = 0;
    int b = 1;

    int sum = 0;


    private static void test() {
        sum = a + b;
    }



    public static void main(String[] args) {



        System.out.println(test());

    }

}
