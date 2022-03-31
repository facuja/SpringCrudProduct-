package com.spring.product.crud.mapper;

import com.spring.product.crud.dto.ProductDTO;
import com.spring.product.crud.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductDTO ProductEntity2DTO(ProductEntity entity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setCode(entity.getCode());
        productDTO.setCurrency(entity.getCurrency());
        productDTO.setDescription(entity.getDescription());
        productDTO.setName(entity.getName());
        productDTO.setPicture(entity.getPicture());
        productDTO.setPrice(entity.getPrice());
        productDTO.setSku(entity.getSku());
        return productDTO;
    }

    public ProductEntity ProductDTO2Entity(ProductDTO dto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCode(dto.getCode());
        productEntity.setCurrency(dto.getCurrency());
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setPicture(dto.getPicture());
        productEntity.setSku(dto.getSku());
        return productEntity;
    }

    public void productEntityRefreshValues(ProductEntity entity, ProductDTO productDTO){
        entity.setSku(productDTO.getSku());
        entity.setPicture((productDTO.getPicture()));
        entity.setPrice(productDTO.getPrice());
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setCurrency(productDTO.getCurrency());
        entity.setCode(productDTO.getCode());
    }

    public List<ProductDTO> ProductEntityList2DTOList(List<ProductEntity> entities){
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity : entities) {
            dtos.add(ProductEntity2DTO(entity));
        }
        return dtos;
    }
}
