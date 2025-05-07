package de.ait.userapi.controller;

import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserDB;
import de.ait.userapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserRepository repository = new UserDB();

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable(name = "id") Long userId) {
        return repository.findById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }
}
