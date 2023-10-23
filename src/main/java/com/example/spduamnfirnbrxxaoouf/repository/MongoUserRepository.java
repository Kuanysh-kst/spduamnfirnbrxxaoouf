package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<MongoUser,Long> {
    Optional<MongoUser> findByFirstPhone(String phone);
    boolean existsByFirstPhone(String phone);

    Optional<MongoUser> findBySecondPhone(String phone);
    boolean existsBySecondPhone(String phone);

    void deleteByFirstPhone(String phone);
    void deleteBySecondPhone(String phone);
}
