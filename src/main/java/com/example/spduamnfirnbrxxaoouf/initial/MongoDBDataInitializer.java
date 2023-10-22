package com.example.spduamnfirnbrxxaoouf.initial;

import com.example.spduamnfirnbrxxaoouf.model.MongoUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class MongoDBDataInitializer {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {
        MongoUser user1 = new MongoUser(1L,"John Doe", new Date(2000, Calendar.OCTOBER,23),"1234567890","1223232343");
        MongoUser user2 = new MongoUser(2L,"Jane Smith", new Date(2001, Calendar.OCTOBER,23),"9876543210","234523455");

        mongoTemplate.save(user1);
        mongoTemplate.save(user2);
    }
}
