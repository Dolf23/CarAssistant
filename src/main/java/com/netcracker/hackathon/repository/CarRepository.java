package com.netcracker.hackathon.repository;

import com.netcracker.hackathon.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findByPlateNumber(String plateNumber);
}
