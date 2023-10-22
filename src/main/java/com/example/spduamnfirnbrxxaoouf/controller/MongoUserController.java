package com.example.spduamnfirnbrxxaoouf.controller;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import com.example.spduamnfirnbrxxaoouf.service.MongoUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mongo/user")
public class MongoUserController {
    private static final Logger log = LoggerFactory.getLogger(MongoUserController.class);

    @Autowired
    MongoUserService mongoUserService;

    @GetMapping("{id}")
    public MongoUser findById(@PathVariable("id") int id) {

        log.info("userMongo: " + mongoUserService.findById(id));
        return mongoUserService.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return mongoUserService.deleteById(id);
    }
}
