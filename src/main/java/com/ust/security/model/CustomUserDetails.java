package com.ust.security.model;

import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Table(name = "creds")
public class CustomUserDetails implements UserDetails{
    private String username;
    private String password;

    public CustomUserDetails(credential c) {
        this.username = c.getUsername();
        this.password = c.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
