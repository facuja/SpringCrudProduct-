package com.spring.product.crud.service;

import com.spring.product.crud.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO addProduct(ProductDTO dto);

    ProductDTO updateProduct(Long id, ProductDTO dto);

    void delete(Long id);
}
