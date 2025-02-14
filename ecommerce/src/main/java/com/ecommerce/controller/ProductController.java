package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/register")
    public String showRegisterForm(Model model, @CookieValue(value = "Authorization", required = false) String token) {

        String memberEmail = null;

        // JWT 검증 및 사용자 이메일 추출
        if (token != null) {
            memberEmail = jwtUtil.validateToken(token);
        }

        if (memberEmail == null) {
            return "redirect:/login"; // JWT가 없거나 유효하지 않으면 로그인 페이지로 이동
        }                               //추후 로그아웃을 추가할 때 수정 필요

        ProductDTO productDTO = new ProductDTO();
        productDTO.setMemberId(memberEmail);
        model.addAttribute("productDTO", productDTO);
        return "product-form";
    }

    @PostMapping("/register")
    public String registerProduct(@ModelAttribute ProductDTO productDTO) {
        productService.save(productDTO);
        return "redirect:/main/all";
    }
}
