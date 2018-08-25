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
    public void whenAddUserThenSortForAge() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivan", 26));
        listUser.add(new User("Gery", 23));
        listUser.add(new User("Miki", 19));
        listUser.add(new User("Gorge", 30));
        Set<User> result = sortUser.sort(listUser);
        assertThat(result.iterator().next().getAge(), is(19));
    }

    @Test
    public void whenAddUserThenSortForLengthName() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Ivanelo", 26));
        listUser.add(new User("Gery", 23));
        listUser.add(new User("Mikis", 19));
        listUser.add(new User("Gop", 30));
        List<User> result = sortUser.sortNameLength(listUser);
        assertThat(result.iterator().next().getName(), is("Gop"));
    }

    @Test
    public void whenAddUserThenSortForNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Sergey", 26));
        listUser.add(new User("Sergey", 30));
        listUser.add(new User("Evgen", 19));
        listUser.add(new User("Evgen", 30));
        List<User> result = sortUser.sortByAllFields(listUser);
        assertThat(result.iterator().next().getName(), is("Evgen"));
    }
}
