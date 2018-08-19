package ru.job4j.tracker;

import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }


    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        do {
            try {
                return this.input.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста введите вариант из меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите правильный запрос.");
            }
        } while (true);
    }
}
