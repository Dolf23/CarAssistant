package com.netcracker.hackathon.service;

import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.DoorsState;
import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.CarRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private UserService userService;

    @Autowired
    public CarService(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public List<Car> getCarsByUserId(ObjectId userId){
        User user = userService.getUserById(userId);
        return (List<Car>) carRepository.findAllById(user.getCars());
    }

    public Car getCarById(ObjectId carId) {
        return null;
    }

    public Car getCarByPlateNumber(String plateNumber) {
        return null;
    }

    public Car registerCar(Car car) {
        return null;
    }

    public Car loginCar(Car car) {
        return null;
    }

    public Car updateCar(Car car) {
        return null;
    }

    public void deleteCar(Car car) {

    }

    public void deleteCarById(ObjectId carId) {

    }

    public void changeCarDoorsState(DoorsState doorsState) {

    }

    public Car getCarDoorState(ObjectId carId) {
        return null;
    }

    public void addUserToCar(ObjectId carId, String phoneNumber) {
        
    }
}
