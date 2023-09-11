package test.devsling.carGarage.model;

// import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Column(name = "id", updatable = false, nullable = false )
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    private String make;
    private String model;
    private LocalDate registrationDate;
    private Double price;
    private FuelType fuelType;
    private Integer mileage;
    private Transmission transmission;
    // For simplicity, i'm using a String to represent the picture URL.
    private String picture;

    public Car(String make, String model, LocalDate registrationDate, Double price, FuelType fuelType, Integer mileage, Transmission transmission, String picture) {
        this.make = make;
        this.model = model;
        this.registrationDate = registrationDate;
        this.price = price;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.transmission = transmission;
        this.picture = picture;
    }
}

