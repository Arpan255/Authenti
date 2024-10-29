package com.ust.security.service;

import com.ust.security.model.CustomUserDetails;
import com.ust.security.model.credential;
import com.ust.security.repository.CredentialRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String u) throws UsernameNotFoundException {
        Optional<credential> credential = credentialRepository.findByUsername(u);
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new RuntimeException("user not found"));
    }
}
