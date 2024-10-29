package com.ust.security.repository;

import com.ust.security.model.credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<credential, Integer>{
    Optional<credential> findByUsername(String username);
}
