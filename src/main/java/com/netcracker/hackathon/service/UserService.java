package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(ObjectId userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByName(String name){
        return userRepository.findByName(name).orElse(null);
    }

    public User createUser(User user){
        User persistentUser = new User(user);
        return userRepository.save(persistentUser);
    }

    public User updateUser(User user){
        Optional<User> updatedUser = userRepository.findByName(user.getName());
        updatedUser.ifPresent(value -> value.updateUser(user));
        return updatedUser.map(value -> userRepository.save(value)).orElse(null);
    }

    public void deleteUser(User user){
        userRepository.findByName(user.getName()).ifPresent(value -> userRepository.delete(value));
    }

    public void deleteUserById(ObjectId userId){
        userRepository.deleteById(userId);
    }
}
