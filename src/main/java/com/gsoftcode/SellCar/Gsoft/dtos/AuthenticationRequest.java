package com.gsoftcode.SellCar.Gsoft.dtos;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;
}
