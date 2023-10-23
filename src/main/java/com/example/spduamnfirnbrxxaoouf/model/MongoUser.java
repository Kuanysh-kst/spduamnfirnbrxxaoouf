package com.example.spduamnfirnbrxxaoouf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "mongoUser")
@Data
public class MongoUser {
    @Id
    public Long id;

    public String name;
    public Date birth;
    public String firstPhone;
    public String secondPhone;

    @Override
    public String toString() {
        return "MongoUser [" +
                "id=" + id +
                ", name=" + name +
                ", birth=" + birth +
                ", firstPhoneNumber=" + firstPhone +
                ", secondPhoneNumber=" + secondPhone +
                ']';
    }
}
