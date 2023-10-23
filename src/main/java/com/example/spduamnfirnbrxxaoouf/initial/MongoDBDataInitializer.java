package com.example.spduamnfirnbrxxaoouf.initial;

import com.example.spduamnfirnbrxxaoouf.model.MongoUserDTO;
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
        MongoUserDTO user1 = new MongoUserDTO(1L,"John Doe", new Date(2000, Calendar.OCTOBER,23),"1234567890","1223232343");
        MongoUserDTO user2 = new MongoUserDTO(2L,"Jane Smith", new Date(2001, Calendar.OCTOBER,23),"9876543210","234523455");
        MongoUserDTO user3 = new MongoUserDTO(3L, "Michael Johnson", new Date(1998, Calendar.DECEMBER, 12), "1111", "3333");
        MongoUserDTO user4 = new MongoUserDTO(4L, "Emily Williams", new Date(1999, Calendar.APRIL, 5), "2222", "4444");
        MongoUserDTO user5 = new MongoUserDTO(5L, "Robert Brown", new Date(1997, Calendar.JULY, 2), "3333", "5555");
        MongoUserDTO user6 = new MongoUserDTO(6L, "Emma Jones", new Date(1995, Calendar.JANUARY, 15), "4444", "6666");
        MongoUserDTO user7 = new MongoUserDTO(7L, "Daniel Miller", new Date(1994, Calendar.AUGUST, 30), "5555", "7777");
        MongoUserDTO user8 = new MongoUserDTO(8L, "Olivia Davis", new Date(1993, Calendar.MARCH, 20), "6666", "8888");
        MongoUserDTO user9 = new MongoUserDTO(9L, "Matthew Wilson", new Date(1992, Calendar.NOVEMBER, 11), "7777", "9999");
        MongoUserDTO user10 = new MongoUserDTO(10L, "Ava Garcia", new Date(1991, Calendar.SEPTEMBER, 25), "8888", "0000");


        mongoTemplate.save(user1);
        mongoTemplate.save(user2);
        mongoTemplate.save(user3);
        mongoTemplate.save(user4);
        mongoTemplate.save(user5);
        mongoTemplate.save(user6);
        mongoTemplate.save(user7);
        mongoTemplate.save(user8);
        mongoTemplate.save(user9);
        mongoTemplate.save(user10);
    }
}
