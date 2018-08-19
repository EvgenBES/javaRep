package ru.job4j.tracker;

import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 19.08.2018
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = 0;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe){
                System.out.println("Пожалуйста введите вариант из меню.");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите правильный запрос.");
            }
        } while (invalid);

        return value;
    }
}
