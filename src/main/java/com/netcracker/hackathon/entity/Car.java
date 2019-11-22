package com.netcracker.hackathon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
@Getter
@Setter
@ToString
public class Car{
    @Id
    private String carId;
    private String plateNumber;
    private String name;
    private String doorsState;

    public Car(){}

    public Car(Car car) {
        this.plateNumber = car.getPlateNumber();
        this.name = car.getName();
        this.doorsState = car.getDoorsState();
    }
}
