package com.example.ui2_demo.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private String useremail;
    private String useraddress;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                            String useremail, String useraddress
    ) {
        super(username, password, authorities);
        this.useraddress = useraddress;
        this.useremail = useremail;
    }
}
