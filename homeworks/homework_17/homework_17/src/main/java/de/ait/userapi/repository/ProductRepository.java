package de.ait.userapi.repository;

import de.ait.userapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAll();
    public Optional<Product> findById(Long id);
    public Product save(Product product);
}
