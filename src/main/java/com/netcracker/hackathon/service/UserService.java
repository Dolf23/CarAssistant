package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName).orElse(null);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone).orElse(null);
    }

    public User createUser(User user) {
        User persistentUser = new User(user);
        return userRepository.insert(persistentUser);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.findByPhoneNumber(user.getPhoneNumber()).ifPresent(value -> userRepository.delete(value));
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    public List<String> getUsersPhonesByCarId(String carId){
        return userRepository.findByCarsIn(carId).stream().map(User::getPhoneNumber).collect(Collectors.toList());
    }
}
