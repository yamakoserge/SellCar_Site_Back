package com.gsoftcode.SellCar.Gsoft.services.customer;

import com.gsoftcode.SellCar.Gsoft.dtos.BidDTO;
import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import com.gsoftcode.SellCar.Gsoft.dtos.SearchCarDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    boolean createCar(CarDTO carDTO) throws IOException;
    boolean updateCar (Long id, CarDTO carDTO) throws IOException;

    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    void deleteCar(Long id);

    List<CarDTO> searchCar(SearchCarDTO searchCarDTO);

    List<CarDTO> getMyCars(Long userId);

    boolean bidACar(BidDTO bidDTO);

    List<BidDTO> getBidsByUserId(Long userId);

    List<BidDTO> getBidsByCarId(Long carId);


}
