package ru.job4j.condition;

/**
 * Package for condition task.
 * Class - stupid Bot.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 28.07.2018
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rls = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rls = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rls = "До скорой встречи.";
        }
        return rls;
    }
}
