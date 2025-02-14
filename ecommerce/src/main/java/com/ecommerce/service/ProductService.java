package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductList();
    void save(ProductDTO productDTO);
}
