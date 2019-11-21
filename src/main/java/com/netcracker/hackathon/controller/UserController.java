package com.netcracker.hackathon.controller;

import com.netcracker.hackathon.entity.User;
import com.netcracker.hackathon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") ObjectId userId){
        log.info("Get user with id={}", userId);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping(path = "/{firstName}/{lastName}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "firstName") String firstName,
                                            @PathVariable(value = "lastName") String lastName){
        log.info("Get user with firstName={}, lastName={}", firstName, lastName);
        return new ResponseEntity<>(userService.getUserByName(firstName, lastName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("Create user {}", user.toString());
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        log.info("Update user {}", user.toString());
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody User user){
        log.info("Delete user {}", user.toString());
        userService.deleteUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUserById(@PathVariable(value = "userId") ObjectId userId){
        log.info("Delete user with id={}", userId);
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
