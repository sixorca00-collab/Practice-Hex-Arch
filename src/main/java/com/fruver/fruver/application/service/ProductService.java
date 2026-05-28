package com.fruver.fruver.application.service;

import com.fruver.fruver.domain.models.Product;
import com.fruver.fruver.domain.ports.in.ProductUseCase;
import com.fruver.fruver.domain.ports.out.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService implements ProductUseCase {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo = repo;
    }

    @Override
    public Product createProduct(Product product){
        return repo.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return repo.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts(){
        return repo.getAllProducts();
    }

    @Override
    public Product updateProduct(Long id,Product product){
        return repo.getProductById(id).map(existProduct -> {
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            return repo.save(existProduct);
        }).orElseThrow(()->new RuntimeException("Product not found"));
    }

    @Override
    public boolean deleteProduct(Long id){
        if (getProductById(id).isPresent()){
            repo.deleteProduct(id);
            return true;
        }
        return false;
    }


}
