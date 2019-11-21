package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName).orElse(null);
    }

    public User getUserByPhone(String phone) {
//        new NotFoundException("User with phone number " + phone + " not found.")
        return userRepository.findByPhoneNumber(phone).orElse(null);
    }

    public User createUser(User user) {
        User persistentUser = new User(user);
        return userRepository.save(persistentUser);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.findByPhoneNumber(user.getPhoneNumber()).ifPresent(value -> userRepository.delete(value));
    }

    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
