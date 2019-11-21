package com.netcracker.hackathon.controller.RequestBody;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PhoneNumberRequestBody {
    private String phoneNumber;

    @Override
    public String toString() {
        return phoneNumber;
    }
}
