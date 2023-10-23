package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.exception.ResourceNotFoundException;
import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteById(long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new ResponseEntity<>("User with id " + id + " has been deleted", HttpStatus.OK);
            } else {
                log.error("User not found with id : " + id);
                return new ResponseEntity<>("User not found with id : " + id, HttpStatus.NOT_FOUND);
            }
        } catch (ResourceNotFoundException e) {
            log.error("Error occurred with id : " + id);
            return new ResponseEntity<>("User not found with id : " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Optional<User> findByFirstPhone(String phone) {
        if (userRepository.existsByFirstPhone(phone)) {
            return userRepository.findByFirstPhone(phone);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findBySecondPhone(String phone) {
        if (userRepository.existsBySecondPhone(phone)) {
            return userRepository.findBySecondPhone(phone);
        } else {
            return Optional.empty();
        }
    }
}
