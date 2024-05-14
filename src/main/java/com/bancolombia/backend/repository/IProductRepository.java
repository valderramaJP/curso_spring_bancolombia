package com.bancolombia.backend.repository;

import com.bancolombia.backend.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);

    Optional<List<ProductEntity>> findByStockGreaterThanEqual(int stock);
}
