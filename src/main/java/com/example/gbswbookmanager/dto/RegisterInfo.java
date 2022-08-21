package com.example.gbswbookmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegisterInfo {
//    @NotEmpty(message = "학번을 적어주세요.")
    private String studentId;

//    @NotEmpty(message = "이름을 적어주세요.")
    private String name;

//    @NotEmpty(message = "이메일을 적어주세요.")
    private String username;

//    @NotEmpty(message = "비밀번호를 적어주세요.")
    private String password;

//    @NotEmpty(message = "인증번호를 적어주세요.")
    private String code;
}
