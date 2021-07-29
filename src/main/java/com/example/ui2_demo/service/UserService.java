package com.example.ui2_demo.service;

import com.example.ui2_demo.entity.User;
import com.example.ui2_demo.form.UserForm;

import java.util.Optional;

public interface UserService {
    public void save(UserForm userForm);
    public Optional<User> findByUserName(String userName);
}
