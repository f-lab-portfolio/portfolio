package com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private String memberId;
    private String productName;
    private int price;
    private int count;

    public ProductDTO(String id, String productName, int price, int count, String memberId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.count = count;
        this.memberId = memberId;
    }
}