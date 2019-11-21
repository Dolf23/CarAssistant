package com.netcracker.hackathon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "cars")
@Getter
@Setter
@ToString
public class Car {
    @Id
    private UUID carId;
    private String name;
    private String state;
    private List<User> users;
}
