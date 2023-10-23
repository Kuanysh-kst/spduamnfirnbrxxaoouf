package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    Optional<User> findByFirstPhone(String phone);
    Optional<User> findById(long id);
    ResponseEntity<String> deleteById(long id);
    Optional<User> findBySecondPhone(String phone);
}
