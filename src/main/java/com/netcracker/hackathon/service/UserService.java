package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(ObjectId userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastName(firstName, lastName).orElse(null);
    }

    public User createUser(User user){
        User persistentUser = new User(user);
        return userRepository.save(persistentUser);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.findByPhoneNumber(user.getPhoneNumber()).ifPresent(value -> userRepository.delete(value));
    }

    public void deleteUserById(ObjectId userId){
        userRepository.deleteById(userId);
    }
}
