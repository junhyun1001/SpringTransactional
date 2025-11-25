package dev.spring.springtransaction.service;

import dev.spring.springtransaction.model.Order;
import dev.spring.springtransaction.model.Product;
import dev.spring.springtransaction.repository.OrderRepository;
import dev.spring.springtransaction.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  public List<Order> getAllOrders() {
    return orderRepository.getAllOrders();
  }

  // 재고 감소 & 주문 저장
  @Transactional
  public void orderProduct(String name, int quantity) {
    Product product = productRepository.findByName(name);
    product.decreaseStock(quantity);
    productRepository.updateProduct(product);

    Order order = new Order(product.getId(), quantity);
    orderRepository.makeOrder(order);

    // 상황 가정: 외부 결제 요청 중 오류 발생
    throw new RuntimeException("결제 서버 점검 중");
  }
}
