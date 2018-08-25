package ru.job4j.comparator;

import java.util.*;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 25.08.2018
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }


    public List<User> sortNameLength(List<User> list) {
        List<User> userList = new ArrayList<>();
        userList.addAll(list);
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return String.valueOf(o1.getName().length()).compareTo(String.valueOf(o2.getName().length()));
            }
        });
        return userList;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> userList = new ArrayList<>();
        userList.addAll(list);
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : o1.getAge().compareTo(o2.getAge());
            }
        });
        return userList;
    }
}
