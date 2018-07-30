package ro.esolutions.ridesharingservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolutions.ridesharingservice.models.CarStatus;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Car {

    private String model;
    private String carId;
    private Driver driver;
    @NotNull
    private CarStatus status;


}
