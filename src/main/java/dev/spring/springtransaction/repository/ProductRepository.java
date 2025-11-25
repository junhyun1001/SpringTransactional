package dev.spring.springtransaction.repository;

import dev.spring.springtransaction.model.Product;
import dev.spring.springtransaction.repository.mapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

  private final JdbcTemplate jdbc;

  public ProductRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  // 모든 재고 조회
  public List<Product> findAllProducts() {
    String sql = "SELECT * FROM product";
    return jdbc.query(sql, new ProductRowMapper());
  }

  // 특정 재고 이름으로 조회
  public Product findByName(String name) {
    String sql = "SELECT * FROM product WHERE name = ?";
    return jdbc.queryForObject(sql, new ProductRowMapper(), name);
  }

  // 재고 업데이트
  public void updateProduct(Product product) {
    String sql = "UPDATE product SET stock = ? WHERE name = ?";
    jdbc.update(sql, product.getStock(), product.getName());
  }
}
