package com.ust.security.service;

import com.ust.security.model.credential;
import com.ust.security.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {
    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public credential addUser(credential c) {
        String password = c.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        c.setPassword(encodedPassword);
        return credentialRepository.saveAndFlush(c);

    }
}
