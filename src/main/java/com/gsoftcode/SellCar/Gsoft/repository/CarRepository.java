package com.gsoftcode.SellCar.Gsoft.repository;

import com.gsoftcode.SellCar.Gsoft.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
