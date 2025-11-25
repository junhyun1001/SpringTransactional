package dev.spring.springtransaction.controller;

import dev.spring.springtransaction.dto.OrderRequest;
import dev.spring.springtransaction.model.Order;
import dev.spring.springtransaction.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/order")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @PostMapping("/order")
  public void makeOrder(@RequestBody OrderRequest request) {
    orderService.orderProduct(request.getName(), request.getQuantity());
  }
}
