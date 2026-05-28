package com.fruver.fruver.domain.ports.out;

import com.fruver.fruver.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    boolean deleteProduct(Long id);
}
