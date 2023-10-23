package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.MongoUserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<MongoUserDTO,Long> {
    Optional<MongoUserDTO> findByFirstPhone(String phone);
    boolean existsByFirstPhone(String phone);

    Optional<MongoUserDTO> findBySecondPhone(String phone);
    boolean existsBySecondPhone(String phone);

    void deleteByFirstPhone(String phone);
    void deleteBySecondPhone(String phone);
}
