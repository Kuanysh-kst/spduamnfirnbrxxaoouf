package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByFirstPhone(String phone);
    Optional<UserDTO> findById(long id);
    ResponseEntity<String> deleteById(long id);
    Optional<UserDTO> findBySecondPhone(String phone);
    List<UserDTO> findAllUsersWithPagination(int limit, int offset);
    ResponseEntity<String> deleteByFirstPhone(String phoneNumber);
    ResponseEntity<String> deleteBySecondPhone(String phoneNumber);
    ResponseEntity<String> updateById(Long id, UserDTO updatedUser);
    ResponseEntity<String> updateByFirstPhone(String phoneNumber, UserDTO updatedUser);
    ResponseEntity<String> updateBySecondPhone(String phoneNumber, UserDTO updatedUser);
}
