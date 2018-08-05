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
     * Бот отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ бота.
     */
    public String answer(String question) {
        String answerBot = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            answerBot = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            answerBot = "До скорой встречи.";
        }
        return answerBot;
    }
}
