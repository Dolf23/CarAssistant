package com.netcracker.hackathon.controller.response;

import com.netcracker.hackathon.entity.Car;
import com.netcracker.hackathon.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserWithCarsResponseBody {
    private User user;
    private List<Car> cars;
}
