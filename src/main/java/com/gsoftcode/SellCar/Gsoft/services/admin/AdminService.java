package com.gsoftcode.SellCar.Gsoft.services.admin;

import com.gsoftcode.SellCar.Gsoft.dtos.BidDTO;
import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import com.gsoftcode.SellCar.Gsoft.dtos.SearchCarDTO;
import com.gsoftcode.SellCar.Gsoft.entities.Car;

import java.util.List;

public interface AdminService {
    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    void deleteCar(Long id);

    List<CarDTO> searchCar(SearchCarDTO searchCarDTO);

    List<CarDTO> getMyCar(Long userId);

    List<BidDTO> getBids();

   boolean changeBidsStatus(Long bidId, String status);

}
