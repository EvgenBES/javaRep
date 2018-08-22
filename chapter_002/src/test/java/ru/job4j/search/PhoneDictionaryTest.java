package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 22.08.2018
 */
public class PhoneDictionaryTest {

    /**
     * Тест проверяет на совподение ключа имени.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentey", "534872", "Bryansk"));
        List<Person> persons = phones.find("Etr");
        assertThat (persons.iterator().next().getName(), is ("Petr"));
    }

    /**
     * Тест проверяет совподение ключа в фамилии.
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentey", "534872", "Bryansk"));
        List<Person> persons = phones.find("seNT");
        assertThat (persons.iterator().next().getSurname(), is ("Arsentey"));
    }

    /**
     * Тест проверяет совподение ключа в номере телефона.
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentey", "534872", "Bryansk"));
        List<Person> persons = phones.find("48");
        assertThat (persons.iterator().next().getPhone(), is ("534872"));
    }

    /**
     * Тест проверяет совподение ключа в адресе.
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentey", "534872", "Bryansk"));
        List<Person> persons = phones.find("brYa");
        assertThat (persons.iterator().next().getAddress(), is ("Bryansk"));
    }

}
