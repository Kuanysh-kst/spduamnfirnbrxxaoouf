package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id) {
        return null;
    }

    public ResponseEntity<String> deleteById(int id) {
        return null;
    }
}
