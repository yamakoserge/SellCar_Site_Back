package com.gsoftcode.SellCar.Gsoft.services.admin;

import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import com.gsoftcode.SellCar.Gsoft.entities.Car;

import java.util.List;

public interface AdminService {
    List<CarDTO> getAllCars();
}
