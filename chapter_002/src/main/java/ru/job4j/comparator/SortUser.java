package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 25.08.2018
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }
}
