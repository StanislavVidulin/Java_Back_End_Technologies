package de.ait.userapi.repository;

import de.ait.userapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// <Product, Long> - название сущности и что является его id
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    // метод save - это и create и update (нет id - create, есть id - update)
    Product save(Product product);
    // ключевое слово + By + имя поля
    List<Product> findProductByTitleStartsWithOrderById(String titlePrefix);
    Long countAllByTitle(String title);
    void deleteByTitle(String title);
}
