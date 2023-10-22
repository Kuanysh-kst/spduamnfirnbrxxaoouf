package com.example.spduamnfirnbrxxaoouf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    public Long id;

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
