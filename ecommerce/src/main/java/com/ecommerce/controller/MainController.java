package com.ecommerce.controller;

import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String findAllProduct(Model model) {
        model.addAttribute("productList",productService.getAllProductList());

        return "main";
    }
}
