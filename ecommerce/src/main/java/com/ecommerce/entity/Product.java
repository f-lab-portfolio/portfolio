package com.ecommerce.entity;

import com.ecommerce.dto.ProductDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Product {
    @Id
    private String id;
    @Column("MEMBER_ID")
    private String memberId;
    @Column("PRODUCT_NAME")
    private String productName;
    @Column("PRICE")
    private int price;
    @Column("COUNT")
    private int count;

    public static Product toProductEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setMemberId(productDTO.getMemberId());
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setCount(productDTO.getCount());

        return product;
    }
}
