package com.bancolombia.backend.service;

import com.bancolombia.backend.dto.ProductDTO;
import com.bancolombia.backend.model.ProductEntity;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity create (ProductDTO productDTO);

    ResponseEntity getAll();

    ResponseEntity getById(long id);

    ResponseEntity getByName(String name);

    ResponseEntity getByStock(int stock);

    ResponseEntity update(long id, ProductDTO productDTO);

    ResponseEntity delete(long id);


}
