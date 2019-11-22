package com.netcracker.hackathon.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarToUserRequestBody {
    private String carId;
    private String phone;
}
