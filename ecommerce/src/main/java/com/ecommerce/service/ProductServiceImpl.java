package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProductList() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productDTOList.add(new ProductDTO(//스트림&람다
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getCount(),
                    product.getMemberId()
            ));
        }
        return productDTOList;
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product product = Product.toProductEntity(productDTO);
        productRepository.save(product);
    }

}