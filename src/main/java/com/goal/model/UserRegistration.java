package com.goal.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRegistration {

    @NotEmpty (message= "아이디를 입력하세요.")
    @NotBlank
    @Size(min=3, max=12, message= "아이디는 최소 3자리 최대 12자리 사이로 입력하세요.")
    String userId;

    @NotEmpty (message= "비밀번호를 입력하세요.")
    @Size(min=8, message= "비밀번호는 최소 8자리 이상 입력하세요.")
    String passwd1;

    @NotEmpty(message="비밀번호를 한번 더 입력하세요")
    String passwd2;

    @NotEmpty (message= "반드시 입력되어야합니다.")
    @NotBlank
    @Size(min=2, max=10, message="닉네임은 최소 2자리 최대 10자리 사이로 입력하세요.")
    String name;

    @NotEmpty(message="이메일 주소를 입력하세요")
    @Email (message="이메일 주소가 올바르지 않습니다")
    String email;

    Integer departmentId;
}
