package com.example.ui2_demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    @NotEmpty
    private String userName;

    @NotEmpty
    private String userPassword;

    @NotEmpty
    private String userPasswordCheck;

    @NotEmpty
    private String userEmail;

    @NotEmpty
    private String userAddress;
}
