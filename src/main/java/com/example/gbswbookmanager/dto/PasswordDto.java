package com.example.gbswbookmanager.dto;

import lombok.Data;

@Data
public class PasswordDto {

    private String username;

    private String password;

    private String newPassword;

    private String newPasswordCheck;

}
