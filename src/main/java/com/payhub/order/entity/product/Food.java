package com.payhub.order.entity.product;

import com.payhub.order.entity.Product;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("F")
@Getter
public class Food extends Product {

    private String expirationDate; //유통기한
    private String ingredients; //구성
    private boolean isVegetarian; //채식

}
