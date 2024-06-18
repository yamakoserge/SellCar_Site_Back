package com.gsoftcode.SellCar.Gsoft.services.customer;

import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    boolean createCar(CarDTO carDTO) throws IOException;

    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);
}
