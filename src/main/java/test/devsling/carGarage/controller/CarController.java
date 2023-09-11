package test.devsling.carGarage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.devsling.carGarage.model.Car;
import test.devsling.carGarage.model.FuelType;
import test.devsling.carGarage.service.CarService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@Api(tags = "Car API", description = "Endpoints for managing cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new car", notes = "Creates a new car entry in the catalog")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        if(car.getRegistrationDate().isAfter(LocalDate.of(2015,1,1))){
            return ResponseEntity.ok(carService.addCar(car));
        }
        return ResponseEntity.badRequest().body(car);
    }

    @GetMapping("/{fuelType}/{maxPrice}")
    @ApiOperation(value = "Get cars by Fuel Type and Max Price", notes = "Retrieves a list of cars based on Fuel Type and Max Price")
    public ResponseEntity<List<Car>> getCarsByFuelTypeAndMaxPrice(@PathVariable FuelType fuelType,@PathVariable Double maxPrice){
        return ResponseEntity.ok(carService.getCarListByFuelAndMaxPrice(fuelType,maxPrice));
    }

    @GetMapping("/getAvailableMake")
    @ApiOperation(value = "Get all available car makes", notes = "Retrieves a list of all available car makes")
    public ResponseEntity<List<String>> getAllAvailableMake(){
        return ResponseEntity.ok(carService.getAllAvailableMake());
    }

    @PutMapping("/{id}/image/{imageUrl}")
    @ApiOperation(value = "Update car picture", notes = "Updates the picture of a car by ID")
    public ResponseEntity<Car> updateCarPicture(@PathVariable String id,@PathVariable String imageUrl){
        return ResponseEntity.ok(carService.updateCarPicture(id,imageUrl));
    }
}
