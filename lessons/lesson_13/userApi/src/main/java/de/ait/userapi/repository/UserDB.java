package de.ait.userapi.repository;

import de.ait.userapi.model.User;

import java.util.HashMap;
import java.util.List;

public class UserDB implements UserRepository{
    private static HashMap<Long, User> map = new HashMap<>();
    static {
        map.put(1L,new User(1L, "Jack", "jack@mail.com"));
        map.put(2L,new User(2L, "John", "john@mail.com"));
        map.put(3L,new User(3L, "Anna", "anna@mail.com"));
        map.put(4L,new User(4L, "Lena", "lena@mail.com"));
        map.put(5L,new User(5L, "Ira", "ira@mail.com"));
        map.put(6L,new User(6L, "Stepan", "stepan@mail.com"));
    }

    public List<User> findAll () {
        return map.values().stream().toList();
    }

    public User findById(long id) {
        return map.get(id);
    }

    @Override
    public User save(User user) {
        map.put(user.getId(), user);
        return user;
    }
}
