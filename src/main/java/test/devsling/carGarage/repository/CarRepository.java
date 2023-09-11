package test.devsling.carGarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.devsling.carGarage.model.Car;
import test.devsling.carGarage.model.FuelType;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,String> {

    @Query("select c from Car c " +
            "where c.fuelType = :fuelType " +
            "and c.price <= :maxPrice ")
    List<Car> getCarListByFuelAndMaxPrice(@Param("fuelType") FuelType fuelType, @Param("maxPrice") Double maxPrice);

    @Query("SELECT DISTINCT c.make FROM Car c")
    List<String> findDistinctMakes();

}
