package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 24.08.2018
 */
public class UserConvertTest {

    @Test
    public void WhenAddListUserToHashMapThenGetUserByKey() {
        UserConvert userConvert = new UserConvert();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(11, "Evgeniy", "Tiraspol"));
        HashMap<Integer, User> result = userConvert.process(listUser);

        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(11, new User(11, "Evgeniy", "Tiraspol"));

        assertThat(result, is(expect));
    }
}
