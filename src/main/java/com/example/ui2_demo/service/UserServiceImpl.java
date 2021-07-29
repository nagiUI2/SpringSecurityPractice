package com.example.ui2_demo.service;

import com.example.ui2_demo.entity.User;
import com.example.ui2_demo.form.UserForm;
import com.example.ui2_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void save(UserForm userForm) { // 꺼내서 넣기
        User userEntity = new User();
        userEntity.setUserName(userForm.getUserName());
        userEntity.setUserPassword(passwordEncoder.encode(userForm.getUserPassword()));
        userEntity.setUserAddress(userForm.getUserAddress());
        userEntity.setUserEmail(userForm.getUserEmail());
        userEntity.setRole("ROLE_USER");
        userRepository.save(userEntity);
    }
}
