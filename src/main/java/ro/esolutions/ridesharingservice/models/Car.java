package ro.esolutions.ridesharingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {

    private String model;
    private String carId;
    private Driver driver;
    private CarStatus status;

}
