package test.devsling.carGarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.devsling.carGarage.model.Car;
import test.devsling.carGarage.model.FuelType;
import test.devsling.carGarage.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCarListByFuelAndMaxPrice(FuelType fuelType, Double maxPrice) {
        return carRepository.getCarListByFuelAndMaxPrice(fuelType,maxPrice);
    }

    @Override
    public List<String> getAllAvailableMake() {
        return carRepository.findDistinctMakes();
    }

    @Override
    public Car updateCarPicture(String carId, String image) {
        Optional<Car> carOp = carRepository.findById(carId);
        if(carOp.isPresent()){
            Car car = carOp.get();
            car.setPicture(image);
            return carRepository.save(car);
        }
        return null;
    }
}
