package com.ecommerce.controller;

import com.ecommerce.dto.LoginRequestDTO;
import com.ecommerce.dto.MemberDTO;
import com.ecommerce.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/join")
    public String addMember() {
        return "register";
    }

    @PostMapping("/register")
    public String saveMember(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "redirect:/main/all";
    }

    @GetMapping("/login")
    public String loginMember(Model model) {
        model.addAttribute("loginRequestDTO", new LoginRequestDTO());
        return "login";
    }

    @PostMapping("/login")
    public String getMember(@Valid @ModelAttribute LoginRequestDTO loginRequestDTO, BindingResult bindingResult, HttpServletResponse response, Model model) {
        if(bindingResult.hasErrors()) {
            return "login";
        }

        if(!memberService.getChkLogin(loginRequestDTO)) {
            model.addAttribute("errorMessage", "이메일 또는 비밀번호가 틀렸습니다.");
            return "login";
        }

        //response.setHeader("Authorization", "Bearer " + memberService.getToken(loginRequestDTO));
        String token = memberService.getToken(loginRequestDTO);

        // HttpOnly & Secure 옵션으로 쿠키에 저장
        Cookie cookie = new Cookie("Authorization", token);
        cookie.setHttpOnly(true); // JavaScript 접근 불가
        cookie.setSecure(true); // HTTPS에서만 전송
        cookie.setPath("/"); // 모든 경로에서 쿠키 사용 가능
        response.addCookie(cookie);

        return "redirect:/main/all";
    }

}
