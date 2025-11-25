package dev.spring.springtransaction.model;

import java.sql.Timestamp;

public class Order {

  private long id;
  private long productId;
  private int quantity;
  private Timestamp createdAt;

  public Order() {
  }

  public Order(Long productId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }
}
