package com.netcracker.hackathon.repository;

import com.netcracker.hackathon.entity.Car;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, ObjectId> {
}
