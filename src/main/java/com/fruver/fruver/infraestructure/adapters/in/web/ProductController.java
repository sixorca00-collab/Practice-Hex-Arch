package com.fruver.fruver.infraestructure.adapters.in.web;

import com.fruver.fruver.domain.models.Product;
import com.fruver.fruver.domain.ports.in.ProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductUseCase productUseCase;

    ProductController(ProductUseCase productUseCase){
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productUseCase.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productUseCase.getAllProducts());
    }

    @GetMapping("/id")
    public ResponseEntity<Product> getProductById(@RequestParam Long id){
        return productUseCase.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestParam Long id, Product product){
        return ResponseEntity.ok(productUseCase.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id){
        if (productUseCase.deleteProduct(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    }
