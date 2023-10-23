package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByFirstPhone(String phone);
    Optional<User> findById(long id);
    ResponseEntity<String> deleteById(long id);
    Optional<User> findBySecondPhone(String phone);
    List<User> findAllUsersWithPagination(int limit, int offset);
    ResponseEntity<String> deleteByFirstPhone(String phoneNumber);
    ResponseEntity<String> deleteBySecondPhone(String phoneNumber);
    ResponseEntity<String> updateById(Long id, User updatedUser);
    ResponseEntity<String> updateByFirstPhone(String phoneNumber, User updatedUser);
    ResponseEntity<String> updateBySecondPhone(String phoneNumber, User updatedUser);
}
