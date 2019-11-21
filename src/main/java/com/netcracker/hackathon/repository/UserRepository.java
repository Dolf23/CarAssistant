package com.netcracker.hackathon.repository;

import com.netcracker.hackathon.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
