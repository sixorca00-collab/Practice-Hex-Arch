package com.fruver.fruver.infraestructure.adapters.out.db;

import com.fruver.fruver.domain.models.Product;
import com.fruver.fruver.domain.ports.out.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductJpaAdapter implements ProductRepository {

    //Inversion
    SpringDataProductRepository springRepo;
    public ProductJpaAdapter(SpringDataProductRepository springRepo){
        this.springRepo = springRepo;
    }

    @Override
    public Product save(Product product){
        ProductEntity entity = ProductEntity.fromDomain(product);
        return springRepo.save(entity).toDomain();
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return springRepo.findById(id).map(ProductEntity ::toDomain);
    }

    @Override
    public List<Product> getAllProducts() {
        return springRepo.findAll().stream().map(ProductEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean deleteProduct(Long id) {
        return springRepo.existsById(id);

    }
}

