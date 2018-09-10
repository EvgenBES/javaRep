package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 24.08.2018
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> listUser = new HashMap<>();

        for (int i = 0; i != list.size(); i++) {
            listUser.put(list.get(i).getId(), list.get(i));
        }
        return listUser;
    }
}
