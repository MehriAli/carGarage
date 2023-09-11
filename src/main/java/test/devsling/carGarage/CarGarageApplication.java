package test.devsling.carGarage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import test.devsling.carGarage.model.Car;
import test.devsling.carGarage.model.FuelType;
import test.devsling.carGarage.model.Transmission;
import test.devsling.carGarage.repository.CarRepository;

import javax.annotation.PostConstruct;
import javax.swing.text.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class CarGarageApplication {

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarGarageApplication.class, args);
	}

	@PostConstruct
	public void insertCarsInDB(){
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("Mercedes","c180", LocalDate.of(2017,5,17)
				,35700.000, FuelType.HYBRID,90000, Transmission.AUTOMATIC, "Document/images/c180.jpg");

		Car car2 = new Car("Renault","Clio", LocalDate.of(2019,8,21)
				,14600.000, FuelType.DIESEL,30000, Transmission.MANUAL, "Document/images/clio.jpg");

		Car car3 = new Car("Citroen","C4", LocalDate.of(2016,10,8)
				,12300.500, FuelType.HYBRID,110000, Transmission.SEMI_AUTOMATIC, "Document/images/c4.jpg");

		Car car4 = new Car("Mercedes","G63", LocalDate.of(2022,11,14)
				,120000.000, FuelType.HYBRID,15000, Transmission.AUTOMATIC, "Document/images/g63.jpg");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		carRepository.saveAll(cars);
	}

}
