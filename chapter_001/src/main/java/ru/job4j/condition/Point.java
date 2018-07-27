package ru.job4j.condition;

/**
 * Package for calculate task.
 * Class - point cordinat X and Y.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 27.07.2018
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод расчёта ростояние между точками.
     * @param that (x; y) коррдинат.
     * @return растояние от Точки А до точки Б.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 5);
        Point b = new Point(2, 5);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}