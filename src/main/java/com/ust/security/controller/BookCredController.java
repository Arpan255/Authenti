package com.ust.security.controller;

import com.ust.security.model.credential;
import com.ust.security.service.CredentialService;
import com.ust.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cred")
public class BookCredController {

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/add")
    public ResponseEntity<credential> addCredential(@RequestBody credential c) {
        return new ResponseEntity<>(credentialService.addUser(c), HttpStatus.CREATED);
    }
    @PostMapping("/validateuser")
    public String getToken(@RequestBody credential c){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(c.getUsername(), c.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(c.getUsername());
        }
        return null;
    }

    @GetMapping("/validateToken")
    public boolean validateToken(@RequestParam String token){
        jwtService.validateToken(token);
        return true;
    }


}
