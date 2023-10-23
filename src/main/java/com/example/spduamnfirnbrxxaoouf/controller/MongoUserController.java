package com.example.spduamnfirnbrxxaoouf.controller;

import com.example.spduamnfirnbrxxaoouf.filter.Filter;
import com.example.spduamnfirnbrxxaoouf.model.MongoUserDTO;
import com.example.spduamnfirnbrxxaoouf.service.MongoUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/mongo/user")
public class MongoUserController {

    @Autowired
    MongoUserServiceImpl mongoUserService;

    @GetMapping("{id}")
    public Optional<MongoUserDTO> findById(@PathVariable("id") int id) {

        log.info("userMongo: " + mongoUserService.findById(id));
        return mongoUserService.findById(id);
    }


    @GetMapping("/phone/one/{first_phone}")
    public Optional<MongoUserDTO> findByFirstPhone(@PathVariable("first_phone") String phoneNumber) {
        log.info("MongoUser by phone number: " + mongoUserService.findByFirstPhone(phoneNumber));
        return mongoUserService.findByFirstPhone(phoneNumber);
    }

    @GetMapping("/phone/two/{second_phone}")
    public Optional<MongoUserDTO> findBySecondPhone(@PathVariable("second_phone") String phoneNumber) {
        log.info("MongoUser by phone number: " + mongoUserService.findBySecondPhone(phoneNumber));
        return mongoUserService.findBySecondPhone(phoneNumber);
    }

    @GetMapping("/users")
    public List<MongoUserDTO> findAllUsers(Filter filter) {
        int limit = filter.getLimit();
        int offset = filter.getOffset();
        return mongoUserService.findAllUsersWithPagination(limit, offset);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody MongoUserDTO updatedUser) {
        log.info("id is :" + id);
        return mongoUserService.updateById(id, updatedUser);
    }

    @PutMapping("/phone/one/{first_phone}")
    public ResponseEntity<String> updateByFirstPhone(@PathVariable("first_phone") String phoneNumber, @RequestBody MongoUserDTO updatedUser) {
        return mongoUserService.updateByFirstPhone(phoneNumber, updatedUser);
    }

    @PutMapping("/phone/two/{second_phone}")
    public ResponseEntity<String> updateBySecondtPhone(@PathVariable("second_phone") String phoneNumber, @RequestBody MongoUserDTO updatedUser) {
        return mongoUserService.updateBySecondPhone(phoneNumber, updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return mongoUserService.deleteById(id);
    }

    @DeleteMapping("/phone/one/{first_phone}")
    public ResponseEntity<String> deleteByFirstPhone(@PathVariable("first_phone") String phoneNumber) {
        return mongoUserService.deleteByFirstPhone(phoneNumber);
    }

    @DeleteMapping("/phone/two/{second_phone}")
    public ResponseEntity<String> deleteBySecondPhone(@PathVariable("second_phone") String phoneNumber) {
        return mongoUserService.deleteBySecondPhone(phoneNumber);
    }

}
