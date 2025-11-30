package dev.spring.springtransaction.repository;

import dev.spring.springtransaction.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductJpaRepository extends CrudRepository<Product, Long> {
  Product findByName(String name);

  List<Product> findAll();
}
