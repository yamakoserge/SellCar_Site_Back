package com.gsoftcode.SellCar.Gsoft.services.customer;


import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import com.gsoftcode.SellCar.Gsoft.entities.Car;
import com.gsoftcode.SellCar.Gsoft.entities.User;
import com.gsoftcode.SellCar.Gsoft.repository.CarRepository;
import com.gsoftcode.SellCar.Gsoft.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final UserRepository userRepository;

    private final CarRepository carRepository;
@Override
    public boolean createCar(CarDTO carDTO) throws IOException {
        Optional<User> optionalUser = userRepository.findById(carDTO.getId());
        if (optionalUser.isPresent()){
            Car car = new Car();
            car.setName(carDTO.getName());
            car.setMarque(carDTO.getMarque());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setTransmission(carDTO.getTransmission());
            car.setSold(false);
            car.setYear(carDTO.getYear());
            car.setImg(carDTO.getImg().getBytes());
            car.setUser(optionalUser.get());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDTO).orElse(null);
    }
}
