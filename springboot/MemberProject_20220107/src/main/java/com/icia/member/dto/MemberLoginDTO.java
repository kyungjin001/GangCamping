package com.icia.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberLoginDTO {
    @NotBlank(message = "로그인시 이메일 필수입력")
    private String memberEmail;
    @NotBlank
    @Length(min = 3, max = 10, message = "비밀번호는 3~10자 사이로 입력")
    private String memberPassword;


}
