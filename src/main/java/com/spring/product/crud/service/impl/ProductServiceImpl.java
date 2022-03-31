package com.spring.product.crud.service.impl;

import com.spring.product.crud.dto.ProductDTO;
import com.spring.product.crud.entity.ProductEntity;
import com.spring.product.crud.exception.ParamNotFound;
import com.spring.product.crud.mapper.ProductMapper;
import com.spring.product.crud.repository.ProductRepository;
import com.spring.product.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> result = productMapper.ProductEntityList2DTOList(entities);
        return result;
    }

    public ProductDTO addProduct(ProductDTO dto){
        ProductEntity productEntity = productMapper.ProductDTO2Entity(dto);
        ProductEntity savedProduct = productRepository.save(productEntity);
        ProductDTO result = productMapper.ProductEntity2DTO(savedProduct);
        return result;
    }

    public ProductDTO updateProduct(Long id, ProductDTO dto){
        Optional<ProductEntity> entity = productRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id no encontrado");
        }
        productMapper.productEntityRefreshValues(entity.get(), dto);
        ProductEntity savedProduct = productRepository.save(entity.get());
        ProductDTO result = productMapper.ProductEntity2DTO(savedProduct);
        return result;
    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }


}
