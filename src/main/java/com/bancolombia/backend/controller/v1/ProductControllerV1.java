package com.bancolombia.backend.controller.v1;

import com.bancolombia.backend.controller.v1.doc.IProductDoc;
import com.bancolombia.backend.dto.ProductDTO;
import com.bancolombia.backend.model.ProductEntity;
import com.bancolombia.backend.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ProductControllerV1 implements IProductDoc {

    private final IProductService productService;

    @Override
    public ResponseEntity create(ProductDTO productDTO) {
        return this.productService.create(productDTO);
    }
}
