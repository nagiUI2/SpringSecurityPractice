package com.example.ui2_demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String userName;

    @NotEmpty
    private String userPassword;
}
