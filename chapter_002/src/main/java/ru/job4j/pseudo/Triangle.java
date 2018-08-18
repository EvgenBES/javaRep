package ru.job4j.pseudo;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 18.08.2018
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pint = new StringBuilder();
        pint.append("   +   ");
        pint.append("  +++  ");
        pint.append(" +++++ ");
        pint.append("+++++++");
        return pint.toString();
    }
}
