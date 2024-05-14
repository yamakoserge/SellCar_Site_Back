package com.gsoftcode.SellCar.Gsoft.dtos;

import com.gsoftcode.SellCar.Gsoft.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private UserRole userRole;
}
