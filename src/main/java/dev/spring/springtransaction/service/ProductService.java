package dev.spring.springtransaction.service;

import dev.spring.springtransaction.model.Product;
import dev.spring.springtransaction.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProduct(String name) {
    return productRepository.findByName(name);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAllProducts();
  }


}
