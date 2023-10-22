package com.example.spduamnfirnbrxxaoouf.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class MongoUser {
    @Id
    public Long id;

    public String name;
    public Date dateOfBirth;
    public String firstPhone;
    public String secondPhone;

    @Override
    public String toString() {
        return "MongoUser [" +
                "id=" + id +
                ", name=" + name +
                ", dateOfBirth=" + dateOfBirth +
                ", firstPhoneNumber=" + firstPhone +
                ", secondPhoneNumber=" + secondPhone +
                ']';
    }
}
