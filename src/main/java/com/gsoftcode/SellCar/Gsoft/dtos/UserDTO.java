package com.gsoftcode.SellCar.Gsoft.dtos;


import com.gsoftcode.SellCar.Gsoft.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;
}
