package com.netcracker.hackathon.controller;

import com.netcracker.hackathon.controller.request.CarToUserRequestBody;
import com.netcracker.hackathon.controller.request.DoorsStateRequestBody;
import com.netcracker.hackathon.controller.request.PhoneNumberRequestBody;
import com.netcracker.hackathon.controller.request.PlateNumberRequestBody;
import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity createCar(@RequestBody Car car){
        return new ResponseEntity(carService.registerCar(car), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{carId}/state")
    public ResponseEntity getCarById(@PathVariable String carId){
        return new ResponseEntity(carService.getCarById(carId), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity getCarsOfUser(@PathVariable(value = "userId") String userId){
        return new ResponseEntity(carService.getCarsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping(path = "/{carId}/state")
    public ResponseEntity changeDoorsState(@PathVariable String carId, @RequestBody DoorsStateRequestBody request){
        return new ResponseEntity(carService.updateCar(carId, request.getDoorsState()), HttpStatus.OK);
    }

    @PostMapping(path = "/{carId}/addUser")
    public ResponseEntity addCarToUser(@PathVariable String carId, @RequestBody PhoneNumberRequestBody request){
        return new ResponseEntity(carService.setCarToUser(carId, request.getPhoneNumber()), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity loginCar(@RequestBody PlateNumberRequestBody requestBody){
        return new ResponseEntity(carService.loginCar(requestBody.getPlateNumber()), HttpStatus.OK);
    }

    @PostMapping(path = "/api/cars/{carId}/removeUser")
    public ResponseEntity deleteCarToUser(@PathVariable String carId, @RequestBody CarToUserRequestBody request){
        return new ResponseEntity(carService.removeCarToUser(request.getCarId(), request.getPhoneNumber()), HttpStatus.OK);
    }
}
