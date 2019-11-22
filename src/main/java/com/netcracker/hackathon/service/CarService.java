package com.netcracker.hackathon.service;

import com.netcracker.hackathon.controller.response.CarWithPhonesResponseBody;
import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.DoorsState;
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
        return (List<Car>) carRepository.findAllById(user.getCars());
    }

    public Car getCarById(String carId) {
        return carRepository.findById(carId).orElse(null);
    }

    public Car getCarByPlateNumber(String plateNumber) {
        return null;
    }

    public Car registerCar(Car car) {
        Car persistantCar = new Car(car);
        return carRepository.insert(car);
    }

    public CarWithPhonesResponseBody loginCar(String plateNumder) {
        Car car = carRepository.findByPlateNumber(plateNumder).orElse(null);
        List<String> phones = userService.getUsersPhonesByCarId(car.getCarId());
        CarWithPhonesResponseBody responseBody = new CarWithPhonesResponseBody();
        responseBody.setCar(car);
        responseBody.setPhones(phones);
        return responseBody;
    }

    public Car updateCar(Car car) {
        return null;
    }

    public Car updateCar(String carId, String doorsState) {
        Car car = carRepository.findById(carId).orElse(new Car());
        car.setDoorsState(doorsState);
        return carRepository.save(car);
    }

    public void deleteCar(Car car) {

    }

    public void deleteCarById(String carId) {

    }

    public void changeCarDoorsState(DoorsState doorsState) {

    }

    public Car getCarDoorState(String carId) {
        return null;
    }

    public void addUserToCar(String carId, String phoneNumber) {
        
    }

    public List<String> setCarToUser(String carId, String phone){
        Car car = carRepository.findById(carId).orElse(new Car());
        User user = userService.getUserByPhone(phone);
        user.getCars().add(car.getCarId());
        return userService.updateUser(user).getCars();
    }
}
