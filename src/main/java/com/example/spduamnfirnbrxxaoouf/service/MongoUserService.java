package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.MongoUserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MongoUserService {
    Optional<MongoUserDTO> findByFirstPhone(String phone);
    Optional<MongoUserDTO> findById(long id);
    ResponseEntity<String> deleteById(long id);
    Optional<MongoUserDTO> findBySecondPhone(String phone);
    List<MongoUserDTO> findAllUsersWithPagination(int limit, int offset);
    ResponseEntity<String> deleteByFirstPhone(String phoneNumber);
    ResponseEntity<String> deleteBySecondPhone(String phoneNumber);
    ResponseEntity<String> updateById(Long id, MongoUserDTO updatedUser);
    ResponseEntity<String> updateByFirstPhone(String phoneNumber, MongoUserDTO updatedUser);
    ResponseEntity<String> updateBySecondPhone(String phoneNumber, MongoUserDTO updatedUser);
}
