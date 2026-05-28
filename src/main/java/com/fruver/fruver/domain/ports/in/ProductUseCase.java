package com.fruver.fruver.domain.ports.in;

import com.fruver.fruver.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase  {
    Product createProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    boolean deleteProduct(Long id);
}
