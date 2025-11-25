package dev.spring.springtransaction.repository.mapper;

import dev.spring.springtransaction.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper<Order> {

  @Override
  public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
    Order order = new Order();
    order.setId(rs.getLong("id"));
    order.setProductId(rs.getLong("product_id"));
    order.setQuantity(rs.getInt("quantity"));
    order.setCreatedAt(rs.getTimestamp("created_at"));
    return order;
  }
}
