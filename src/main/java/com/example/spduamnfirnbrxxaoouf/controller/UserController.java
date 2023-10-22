package com.example.spduamnfirnbrxxaoouf.controller;

import com.example.spduamnfirnbrxxaoouf.model.User;
import com.example.spduamnfirnbrxxaoouf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pg/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @GetMapping("{id}")
    public User findById(@PathVariable("id") int id) {

        log.info("PGUser: " + service.findById(id));
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return service.deleteById(id);
    }
}
