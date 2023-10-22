package com.example.spduamnfirnbrxxaoouf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "user")
public class User {
    @Id
    public int id;

    public String name;
    public Date dateOfBirth;
    public String firstPhone;
    public String secondPhone;

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", name=" + name +
                ", dateOfBirth=" + dateOfBirth +
                ", firstPhoneNumber=" + firstPhone +
                ", secondPhoneNumber=" + secondPhone +
                ']';
    }
}
