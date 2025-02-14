package com.ecommerce.entity;

import com.ecommerce.dto.MemberDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Member {
    @Id
    private Long id;
    @Column("MEMBER_EMAIL")
    private String memberEmail;
    @Column("MEMBER_PASSWORD")
    private String memberPassword;
    @Column("MEMBER_NAME")
    private String memberName;

    public static Member toMemberEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setMemberEmail(memberDTO.getMemberEmail());
        member.setMemberName(memberDTO.getMemberName());
        member.setMemberPassword(memberDTO.getMemberPassword());

        return member;
    }
}
