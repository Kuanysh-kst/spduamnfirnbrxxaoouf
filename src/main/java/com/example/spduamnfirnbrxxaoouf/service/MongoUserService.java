package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MongoUserService {
    Optional<MongoUser> findByFirstPhone(String phone);
    Optional<MongoUser> findById(long id);
    ResponseEntity<String> deleteById(long id);
    Optional<MongoUser> findBySecondPhone(String phone);
    List<MongoUser> findAllUsersWithPagination(int limit, int offset);
    ResponseEntity<String> deleteByFirstPhone(String phoneNumber);
    ResponseEntity<String> deleteBySecondPhone(String phoneNumber);
    ResponseEntity<String> updateById(Long id, MongoUser updatedUser);
    ResponseEntity<String> updateByFirstPhone(String phoneNumber, MongoUser updatedUser);
    ResponseEntity<String> updateBySecondPhone(String phoneNumber, MongoUser updatedUser);
}
