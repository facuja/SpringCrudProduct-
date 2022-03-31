package com.spring.product.crud.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long sku;

    @Column(unique = true, nullable = false)
    private Long code;

    @Column(nullable = false)
    private String name;

    private String description;

    private String picture;

    @Column(nullable = false)
    private float price;

    private String currency;

}
