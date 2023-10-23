package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.exception.ResourceNotFoundException;
import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import com.example.spduamnfirnbrxxaoouf.repository.MongoUserRepository;
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
@Service("userMongoService")
public class MongoUserServiceImpl implements MongoUserService{

    private MongoUserRepository mongoUserRepository;

    @Autowired
    public MongoUserServiceImpl(MongoUserRepository repository) {
        this.mongoUserRepository = repository;
    }

    @Override
    public Optional<MongoUser> findById(long id) {
        return mongoUserRepository.findById(id);
    }

    @Override
    public Optional<MongoUser> findByFirstPhone(String phone) {
        if (mongoUserRepository.existsByFirstPhone(phone)) {
            return mongoUserRepository.findByFirstPhone(phone);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public ResponseEntity<String> deleteById(long id) {
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

    @Override
    public Optional<MongoUser> findBySecondPhone(String phone) {
        if (mongoUserRepository.existsBySecondPhone(phone)) {
            return mongoUserRepository.findBySecondPhone(phone);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<MongoUser> findAllUsersWithPagination(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<MongoUser> page = mongoUserRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public ResponseEntity<String> deleteByFirstPhone(String phoneNumber) {
        if (mongoUserRepository.existsByFirstPhone(phoneNumber)) {
            mongoUserRepository.deleteByFirstPhone(phoneNumber);
            return new ResponseEntity<>("MongoUser with first phone number " + phoneNumber + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("MongoUser with first phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteBySecondPhone(String phoneNumber) {
        if (mongoUserRepository.existsBySecondPhone(phoneNumber)) {
            mongoUserRepository.deleteBySecondPhone(phoneNumber);
            return new ResponseEntity<>("MongoUser with second phone number " + phoneNumber + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("MongoUser with second phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateById(Long id, MongoUser updatedUser) {
        Optional<MongoUser> existingUser = mongoUserRepository.findById(id);
        if (existingUser.isPresent()) {
            MongoUser mongoUser = existingUser.get();
            mongoUser.setName(updatedUser.getName());
            mongoUser.setBirth(updatedUser.getBirth());
            mongoUser.setFirstPhone(updatedUser.getFirstPhone());
            mongoUser.setSecondPhone(updatedUser.getSecondPhone());
            mongoUserRepository.save(mongoUser);
            return new ResponseEntity<>("MongoUser with ID " + id + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("MongoUser with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateByFirstPhone(String phoneNumber, MongoUser updatedUser) {
        Optional<MongoUser> existingUser = mongoUserRepository.findByFirstPhone(phoneNumber);
        if (existingUser.isPresent()) {
            MongoUser mongoUser = existingUser.get();
            mongoUser.setName(updatedUser.getName());
            mongoUser.setBirth(updatedUser.getBirth());
            mongoUser.setSecondPhone(updatedUser.getSecondPhone());
            mongoUserRepository.save(mongoUser);
            return new ResponseEntity<>("MongoUser with first phone number " + phoneNumber + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("MongoUser with first phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateBySecondPhone(String phoneNumber, MongoUser updatedUser) {
        Optional<MongoUser> existingUser = mongoUserRepository.findBySecondPhone(phoneNumber);
        if (existingUser.isPresent()) {
            MongoUser mongoUser = existingUser.get();
            mongoUser.setName(updatedUser.getName());
            mongoUser.setBirth(updatedUser.getBirth());
            mongoUser.setSecondPhone(updatedUser.getSecondPhone());
            mongoUserRepository.save(mongoUser);
            return new ResponseEntity<>("MongoUser with second phone number " + phoneNumber + " updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("MongoUser with second phone number " + phoneNumber + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
