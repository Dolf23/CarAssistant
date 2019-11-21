package com.netcracker.hackathon.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    private ObjectId userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private List<ObjectId> cars;

    public User() {
    }

    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
    }
}
