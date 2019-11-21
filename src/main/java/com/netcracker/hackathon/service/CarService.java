package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private CarRepository carRepository;
    private UserService userService;

    @Autowired
    public CarService(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public List<Car> getCarsByUserId(UUID userId){
        User user = userService.getUserById(userId);
        return (List<Car>) carRepository.findAllById(user.getCars());
    }
}
