package com.payhub.order.entity.product;

import com.payhub.order.entity.Product;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("C")
@Getter
public class Clothes extends Product {

    private String size;
    private String color;
    private String material; //제료

}
