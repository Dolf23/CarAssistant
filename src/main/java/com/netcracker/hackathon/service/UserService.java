package com.netcracker.hackathon.service;

import com.netcracker.hackathon.controller.response.UserWithCarsResponseBody;
import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.CarRepository;
import com.netcracker.hackathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private CarRepository carRepository;
    private UserRepository userRepository;

    @Autowired
    public UserService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
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
        return userRepository.findByCarIdsIn(carId).stream().map(User::getPhoneNumber).collect(Collectors.toList());
    }

    public UserWithCarsResponseBody getUserWithIds(String phone){
        User user = getUserByPhone(phone);
        List<Car> cars = (List<Car>) carRepository.findAllById(user.getCarIds());
        UserWithCarsResponseBody responseBody = new UserWithCarsResponseBody();
        responseBody.setUser(user);
        responseBody.setCars(cars);
        return responseBody;
    }
}
