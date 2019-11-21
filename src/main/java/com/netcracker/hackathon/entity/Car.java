package com.netcracker.hackathon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
@Getter
@Setter
@ToString
public class Car {
    @Id
    private ObjectId carId;
    private String plateNumber;
    private String name;
    private String doorsState;
}
