package de.ait.userapi.repository;

import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

//@Repository
public class UserDB { //implements UserRepository
    private Long lastId = 6L;
    private static HashMap<Long, User> map = new HashMap<>();
    static {
        map.put(1L,new User(1L, "Jack", "jack@mail.com", "qwe1"));
        map.put(2L,new User(2L, "John", "john@mail.com", "qwe2"));
        map.put(3L,new User(3L, "Anna", "anna@mail.com", "qwe3"));
        map.put(4L,new User(4L, "Lena", "lena@mail.com", "qwe4"));
        map.put(5L,new User(5L, "Ira", "ira@mail.com", "qwe5"));
        map.put(6L,new User(6L, "Stepan", "stepan@mail.com", "qwe6"));
    }

    public List<User> findAll () {
        return map.values().stream().toList();
    }

    public User findById(long id) {
        User user = map.get(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
//        return map.get(id);
    }

    public User save(User user) {
        user.setId(++lastId);
        map.put(user.getId(), user);
        return user;
    }
}