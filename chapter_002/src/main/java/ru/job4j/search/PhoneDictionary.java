package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 22.08.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }


    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        String lowerCaseKey = key.toLowerCase();

        for (Person person : persons) {
            if (person.getSurname().toLowerCase().contains(lowerCaseKey)
                    || person.getName().toLowerCase().contains(lowerCaseKey)
                    || person.getAddress().toLowerCase().contains(lowerCaseKey)
                    || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

}
