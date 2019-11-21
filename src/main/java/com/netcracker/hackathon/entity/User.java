package com.netcracker.hackathon.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(User user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
    }

    public void updateUser(User user){
        if (!this.getName().equals(user.getName()))
            this.setName(user.getName());
        if (!this.getEmail().equals(user.getEmail()))
            this.setEmail(user.getEmail());
        if (!this.getPassword().equals(user.getPassword()))
            this.setPassword(user.getPassword());
    }
}
