package com.spring.product.crud.controller;

import com.spring.product.crud.dto.ProductDTO;
import com.spring.product.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<ProductDTO>addProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO productSaved = productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO>updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO productUpdated = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok().body(productUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
        this.productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
