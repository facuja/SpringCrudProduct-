package com.spring.product.crud.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    @NotNull(message = "Por favor ingrese un SKU")
    private Long sku;

    @NotNull(message = "Por favor ingrese un codigo")
    private Long code;

    @NotBlank
    @Size(min = 2, message = "El nombre del producto debe tener al menos 2 letras")
    private String name;

    private String description;

    private String picture;

    @DecimalMin(value = "0.1", message = "El valor debe ser mayor a 0.0")
    private float price;

    private String currency;
}
