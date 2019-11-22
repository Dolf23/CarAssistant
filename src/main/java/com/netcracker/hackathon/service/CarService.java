package com.netcracker.hackathon.service;

import com.netcracker.hackathon.controller.response.CarWithPhonesResponseBody;
import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.repository.CarRepository;
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

    public List<Car> getCarsByUserId(String userId){
        User user = userService.getUserById(userId);
        return (List<Car>) carRepository.findAllById(user.getCarIds());
    }

    public Car getCarById(String carId) {
        return carRepository.findById(carId).orElse(null);
    }

    public Car registerCar(Car car) {
        Car persistantCar = new Car(car);
        return carRepository.insert(car);
    }

    public CarWithPhonesResponseBody loginCar(String plateNumber) {
        Car car = carRepository.findByPlateNumber(plateNumber).orElse(null);
        List<String> phones = userService.getUsersPhonesByCarId(car.getCarId());
        CarWithPhonesResponseBody responseBody = new CarWithPhonesResponseBody();
        responseBody.setCar(car);
        responseBody.setPhoneNumbers(phones);
        return responseBody;
    }

    public Car updateCar(String carId, String doorsState) {
        Car car = carRepository.findById(carId).orElse(new Car());
        car.setDoorsState(doorsState);
        return carRepository.save(car);
    }

    public CarWithPhonesResponseBody setCarToUser(String carId, String phone){
        Car car = carRepository.findById(carId).orElse(new Car());
        User user = userService.getUserByPhone(phone);
        user.getCarIds().add(car.getCarId());
        userService.updateUser(user);
        return loginCar(car.getPlateNumber());
    }

public CarWithPhonesResponseBody removeCarToUser(String carId, String phone) {
        Car car = getCarById(carId);
        User user = userService.getUserByPhone(phone);
        user.getCarIds().remove(car.getCarId());
        List<String> phones = userService.getUsersPhonesByCarId(car.getCarId());
        CarWithPhonesResponseBody responseBody = new CarWithPhonesResponseBody();
        responseBody.setCar(car);
        responseBody.setPhoneNumbers(phones);
        userService.updateUser(user);
        return responseBody;
    }
}
