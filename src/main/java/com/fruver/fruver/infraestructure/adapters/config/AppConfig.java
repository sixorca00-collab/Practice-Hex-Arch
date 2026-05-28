package com.fruver.fruver.infraestructure.adapters.config;

import com.fruver.fruver.application.service.ProductService;
import com.fruver.fruver.domain.ports.in.ProductUseCase;
import com.fruver.fruver.domain.ports.out.ProductRepository;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepository){
        return new ProductService(productRepository);
    }
}
