package dev.spring.springtransaction.model;

import org.springframework.data.annotation.Id;

public class Product {

  @Id
  private long id;
  private String name;
  private int price;
  private int stock;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public void decreaseStock(int quantity) {
    stock -= quantity;
  }
}
