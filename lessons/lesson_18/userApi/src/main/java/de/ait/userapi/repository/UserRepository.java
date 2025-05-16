package de.ait.userapi.repository;

import de.ait.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public Stream<User> findByName(String name);
    public List<User> findByNameOrEmail(String name, String email);
    public User save(User user);
    public Long countAllByName(String name);
}
