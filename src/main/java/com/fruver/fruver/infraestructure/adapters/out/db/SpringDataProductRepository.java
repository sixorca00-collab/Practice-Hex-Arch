package com.fruver.fruver.infraestructure.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository  extends JpaRepository<ProductEntity, Long> {
}
