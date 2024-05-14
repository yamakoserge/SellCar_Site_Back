package com.gsoftcode.SellCar.Gsoft.services.auth;

import com.gsoftcode.SellCar.Gsoft.dtos.SignupRequest;
import com.gsoftcode.SellCar.Gsoft.dtos.UserDTO;

public interface AuthService {


    UserDTO signup(SignupRequest signupRequest);
    Boolean hasUserWithEmail(String email);
}
