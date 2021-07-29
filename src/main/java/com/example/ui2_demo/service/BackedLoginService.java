package com.example.ui2_demo.service;

import com.example.ui2_demo.entity.User;
import com.example.ui2_demo.repository.UserRepository;
import com.example.ui2_demo.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class BackedLoginService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(()-> new IllegalArgumentException("not"));
        CustomUserDetails customUserDetails =
                new CustomUserDetails(user.getUserName(), user.getUserPassword(),
                        Arrays.asList(new SimpleGrantedAuthority(user.getRole())),
                        user.getUserEmail(), user.getUserAddress()
                );
        return customUserDetails;

    }
}
