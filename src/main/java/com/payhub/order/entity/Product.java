package com.payhub.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글 테이블 전략
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long productId;

    private String name;
    private int price;
    private int stockQuantity;

}
