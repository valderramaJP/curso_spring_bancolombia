package com.bancolombia.backend.service.impl;

import com.bancolombia.backend.dto.ProductDTO;
import com.bancolombia.backend.exception.MyHandleException;
import com.bancolombia.backend.model.ProductEntity;
import com.bancolombia.backend.repository.IProductRepository;
import com.bancolombia.backend.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ResponseEntity create(ProductDTO productDTO) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setStock(productDTO.getStock());
        productEntity.setCreateAt(productDTO.getCreateAt());

        ProductEntity product = this.productRepository.save(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity getAll() {

        var productList = this.productRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @Override
    public ResponseEntity getById(long id) {
        var product = this.productRepository.findById(id);
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity getByName(String name) {

        var productEntity = this.productRepository.findByName(name);
        return ResponseEntity.ok(productEntity);
    }

    @Override
    public ResponseEntity getByStock(int stock) {

        var productEntity = this.productRepository.findByStockGreaterThanEqual(stock);
        return ResponseEntity.ok(productEntity);
    }

    @Override
    public ResponseEntity update(long id, ProductDTO productDTO) {
        var productEntity = this
                .productRepository
                .findById(id)
                .orElseThrow(
                        ()-> new MyHandleException("""
                el producto a actualizar con el id %s no existe.
                """.formatted(id))
                );

            productEntity.setName(productDTO.getName());
            productEntity.setStock(productDTO.getStock());

            var updatedProduct = this.productRepository.save(productEntity);

            return ResponseEntity.ok(updatedProduct);

    }

    @Override
    public ResponseEntity delete(long id) {
        return null;
    }


}
