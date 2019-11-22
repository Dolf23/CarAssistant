package com.netcracker.hackathon.controller.response;

import com.netcracker.hackathon.entity.Car;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
public class CarWithPhonesResponseBody {
    private Car car;
    private List<String> phones;
}
