package de.ait.userapi.repository;

import de.ait.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAll();
    public Optional<User> findById(long id);
    public User save(User user);
}
