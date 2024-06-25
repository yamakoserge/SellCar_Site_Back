package com.gsoftcode.SellCar.Gsoft.services.admin;

import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import com.gsoftcode.SellCar.Gsoft.entities.Car;
import com.gsoftcode.SellCar.Gsoft.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final CarRepository carRepository;

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDTO).collect(Collectors.toList());

    }
    @Override
    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDTO).orElse(null);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }


}
