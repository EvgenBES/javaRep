package ru.job4j.comparator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 25.08.2018
 */
public class SortUserTest {

    @Test
    public void whenUserTest() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 26));
        listUser.add(new User("Gery", 23));
        listUser.add(new User("Miki", 19));
        listUser.add(new User("Gorge", 30));
        Set<User> result = sortUser.sort(listUser);
        assertThat(result.iterator().next().getAge(), is(19));
    }
}
