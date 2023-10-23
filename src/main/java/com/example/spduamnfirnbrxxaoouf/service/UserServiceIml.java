package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.exception.ResourceNotFoundException;
import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<User> findAllUsersWithPagination(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<User> page = userRepository.findAll(pageable);
        return page.getContent();
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

    @Transactional
    @Override
    public ResponseEntity<String> deleteByFirstPhone(String phoneNumber) {
        if (userRepository.existsByFirstPhone(phoneNumber)) {
            userRepository.deleteByFirstPhone(phoneNumber);
            return new ResponseEntity<>("User with first phone number " + phoneNumber + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with first phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<String> deleteBySecondPhone(String phoneNumber) {
        if (userRepository.existsBySecondPhone(phoneNumber)) {
            userRepository.deleteBySecondPhone(phoneNumber);
            return new ResponseEntity<>("User with second phone number " + phoneNumber + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with second phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateById(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setBirth(updatedUser.getBirth());
            user.setFirstPhone(updatedUser.getFirstPhone());
            user.setSecondPhone(updatedUser.getSecondPhone());
            userRepository.save(user);
            return new ResponseEntity<>("User with ID " + id + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateByFirstPhone(String phoneNumber, User updatedUser) {
        Optional<User> existingUser = userRepository.findByFirstPhone(phoneNumber);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setBirth(updatedUser.getBirth());
            user.setFirstPhone(updatedUser.getFirstPhone());
            user.setSecondPhone(updatedUser.getSecondPhone());
            userRepository.save(user);
            return new ResponseEntity<>("User with first phone number " + phoneNumber + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with first phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateBySecondPhone(String phoneNumber, User updatedUser) {
        Optional<User> existingUser = userRepository.findBySecondPhone(phoneNumber);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setBirth(updatedUser.getBirth());
            user.setFirstPhone(updatedUser.getFirstPhone());
            user.setSecondPhone(updatedUser.getSecondPhone());
            userRepository.save(user);
            return new ResponseEntity<>("User with second phone number " + phoneNumber + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with second phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
