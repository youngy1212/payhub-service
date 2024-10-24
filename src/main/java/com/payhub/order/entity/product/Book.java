package com.payhub.order.entity.product;

import com.payhub.order.entity.Product;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("B")
@Getter
public class Book extends Product {

    private String author; //작가
    private String isbn; //일련번호
    private String publisher; //출판사
}
