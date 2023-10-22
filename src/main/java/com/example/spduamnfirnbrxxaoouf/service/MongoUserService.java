package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.exception.ResourceNotFoundException;
import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import com.example.spduamnfirnbrxxaoouf.repository.MongoUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("userMongoService")
public class MongoUserService {
    private static final Logger log = LoggerFactory.getLogger(MongoUserService.class);


    private MongoUserRepository mongoUserRepository;

    @Autowired
    public MongoUserService(MongoUserRepository repository) {
        this.mongoUserRepository = repository;
    }

    public MongoUser findById(int id) {
        return mongoUserRepository.findById(id);
    }

    public MongoUser findByPhone(String phone) {
        return mongoUserRepository.findByFirstPhone(phone);
    }

    public ResponseEntity<String> deleteById(int id) {
        try {
            if (mongoUserRepository.existsById(id)) {
                mongoUserRepository.deleteById(id);
                return new ResponseEntity<>("MongoUser with id " + id + " has been deleted", HttpStatus.OK);
            } else {
                log.error("MongoUser not found with id : " + id);
                return new ResponseEntity<>("MongoUser not found with id : " + id, HttpStatus.NOT_FOUND);
            }
        } catch (ResourceNotFoundException e) {
            log.error("Error occurred with id : " + id);
            return new ResponseEntity<>("MongoUser not found with id : " + id, HttpStatus.NOT_FOUND);
        }
    }
}
