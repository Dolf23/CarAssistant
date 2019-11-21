package com.netcracker.hackathon.controller.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PhoneNumberRequestBody {
    private String phoneNumber;

    @Override
    public String toString() {
        return phoneNumber;
    }
}
