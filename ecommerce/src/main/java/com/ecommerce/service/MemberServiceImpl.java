package com.ecommerce.service;

import com.ecommerce.dto.LoginRequestDTO;
import com.ecommerce.entity.Member;
import com.ecommerce.dto.MemberDTO;
import com.ecommerce.repository.MemberRepository;
import com.ecommerce.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void save(MemberDTO memberDTO) {
        //DTO -> entity
        Member member = Member.toMemberEntity(memberDTO);

        memberRepository.save(member);
    }

    @Override
    public boolean getChkLogin(LoginRequestDTO loginRequestDTO) {
        Optional<Member> memberOptional = memberRepository.findByMemberEmail(loginRequestDTO.getMemberEmail());

        if(memberOptional.isPresent()) {
           return memberOptional.get().getMemberPassword().equals(loginRequestDTO.getMemberPassword());
        }

        return false;
    }

    @Override
    public String getToken(LoginRequestDTO loginRequestDTO) {
        return jwtUtil.generateToken(loginRequestDTO.getMemberEmail());
    }
}
