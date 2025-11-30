package dev.spring.springtransaction.repository;

import dev.spring.springtransaction.model.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductJpaRepository extends CrudRepository<Product, Long> {
  Product findByName(String name);

  List<Product> findAll();

  @Modifying
  @Query("UPDATE product SET stock = :#{#product.stock} WHERE name = :#{#product.name}")
  void updateProduct(Product product);
}
