package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser,String> {
}
