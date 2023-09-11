package test.devsling.carGarage.service;

import org.springframework.stereotype.Service;
import test.devsling.carGarage.model.Car;
import test.devsling.carGarage.model.FuelType;

import java.util.List;

@Service
public interface CarService {
    Car addCar(Car car);
    List<Car> getCarListByFuelAndMaxPrice(FuelType fuelType, Double maxPrice);
    List<String> getAllAvailableMake();
    Car updateCarPicture(String carId, String image);
}
