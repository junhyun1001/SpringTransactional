package dev.spring.springtransaction.repository;

import dev.spring.springtransaction.model.Order;
import dev.spring.springtransaction.repository.mapper.OrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

  private final JdbcTemplate jdbc;

  public OrderRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<Order> getAllOrders() {
    String sql = "SELECT * FROM orders";
    return jdbc.query(sql, new OrderRowMapper());
  }

  // 주문 저장
  public void makeOrder(Order order) {
    String sql = "INSERT INTO orders (product_id, quantity) VALUES (?, ?)";
    jdbc.update(sql, order.getProductId(), order.getQuantity());
  }

}
