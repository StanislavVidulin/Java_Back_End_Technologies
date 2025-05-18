package de.ait.tasks.repository;

import de.ait.tasks.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    List<Programmer> findAll();
    Optional<Programmer> findById(Long id);
    void deleteById(Long id);
    Programmer save(Programmer programmer);
}
