package com.example.spduamnfirnbrxxaoouf.controller;

import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.service.UserServiceIml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/pg/user")
public class UserController {

    @Autowired
    UserServiceIml service;

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

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return service.deleteById(id);
    }
}
