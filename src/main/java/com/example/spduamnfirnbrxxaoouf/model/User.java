package com.example.spduamnfirnbrxxaoouf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "users")
public class User {
    @Id
    public Long id;

    public String name;
    public Date birth;

    @Column(name = "first_phone")
    public String firstPhone;
    @Column(name = "second_phone")
    public String secondPhone;

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", name=" + name +
                ", birth=" + birth +
                ", firstPhoneNumber=" + firstPhone +
                ", secondPhoneNumber=" + secondPhone +
                ']';
    }
}
