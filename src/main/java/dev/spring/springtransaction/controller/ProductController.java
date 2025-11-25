package dev.spring.springtransaction.controller;

import dev.spring.springtransaction.dto.ProductRequest;
import dev.spring.springtransaction.model.Product;
import dev.spring.springtransaction.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/product")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping("/product")
  public Product getProduct(@RequestBody ProductRequest request) {
    return productService.getProduct(request.getName());
  }
}
