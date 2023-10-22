package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser,String> {

    MongoUser findById(int id);

    MongoUser findByFirstPhone(String phone);

    void deleteById(int id);

    boolean existsById(int id);
}
