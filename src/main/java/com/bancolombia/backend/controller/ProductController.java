package com.bancolombia.backend.controller;

import com.bancolombia.backend.dto.ProductDTO;
import com.bancolombia.backend.model.ProductEntity;
import com.bancolombia.backend.repository.IProductRepository;
import com.bancolombia.backend.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/products")
@AllArgsConstructor
public class ProductController {

    //Comunicar Controller con el Service.
    private final IProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ProductDTO productDTO){
        return this.productService.create(productDTO);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity getById(@PathVariable long id){
        return this.productService.getById(id);
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        return this.productService.getByName(name);
    }

    @GetMapping("/getbystock/{stock}")
    public ResponseEntity getByName(@PathVariable int stock){
        return this.productService.getByStock(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody ProductDTO productDTO){
        return this.productService.update(id, productDTO);
    }
}
