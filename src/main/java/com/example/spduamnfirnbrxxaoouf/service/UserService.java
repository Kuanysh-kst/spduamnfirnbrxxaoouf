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
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

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
}
