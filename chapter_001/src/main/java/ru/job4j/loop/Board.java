package ru.job4j.loop;

/**
 * Package for loop task.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */

public class Board {

    /**
     * Рисуем шахматную доску.
     *
     * @param width,height - ширина и высота доски.
     * @return Строку, которая нарисует доску.
     */

    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
