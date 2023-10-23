package com.example.spduamnfirnbrxxaoouf.controller;

import com.example.spduamnfirnbrxxaoouf.filter.Filter;
import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/pg/user")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable("id") int id) {
        log.info("PGUser: " + service.findById(id));
        return service.findById(id);
    }

    @GetMapping("/phone/one/{first_phone}")
    public Optional<User> findByFirstPhone(@PathVariable("first_phone") String phoneNumber) {
        log.info("PGUser by phone number: " + service.findByFirstPhone(phoneNumber));
        return service.findByFirstPhone(phoneNumber);
    }

    @GetMapping("/phone/two/{second_phone}")
    public Optional<User> findBySecondPhone(@PathVariable("second_phone") String phoneNumber) {
        log.info("PGUser by phone number: " + service.findBySecondPhone(phoneNumber));
        return service.findBySecondPhone(phoneNumber);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(Filter filter) {
        int limit = filter.getLimit();
        int offset = filter.getOffset();
        return service.findAllUsersWithPagination(limit, offset);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        log.info("id is :" + id);
        return service.updateById(id, updatedUser);
    }

    @PutMapping("/phone/one/{first_phone}")
    public ResponseEntity<String> updateByFirstPhone(@PathVariable("first_phone") String phoneNumber, @RequestBody User updatedUser) {
        return service.updateByFirstPhone(phoneNumber, updatedUser);
    }

    @PutMapping("/phone/two/{second_phone}")
    public ResponseEntity<String> updateBySecondtPhone(@PathVariable("second_phone") String phoneNumber, @RequestBody User updatedUser) {
        return service.updateBySecondPhone(phoneNumber, updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/phone/one/{first_phone}")
    public ResponseEntity<String> deleteByFirstPhone(@PathVariable("first_phone") String phoneNumber) {
        return service.deleteByFirstPhone(phoneNumber);
    }

    @DeleteMapping("/phone/two/{second_phone}")
    public ResponseEntity<String> deleteBySecondPhone(@PathVariable("second_phone") String phoneNumber) {
        return service.deleteBySecondPhone(phoneNumber);
    }

}
