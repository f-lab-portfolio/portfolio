package com.ecommerce.service;

import com.ecommerce.dto.LoginRequestDTO;
import com.ecommerce.dto.MemberDTO;

public interface MemberService {
    void save(MemberDTO memberDTO);
    boolean getChkLogin(LoginRequestDTO loginRequestDTO);
    String getToken(LoginRequestDTO loginRequestDTO);

}
