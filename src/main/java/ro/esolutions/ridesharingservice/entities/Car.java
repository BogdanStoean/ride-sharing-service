package ro.esolutions.ridesharingservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolutions.ridesharingservice.models.CarStatus;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "CAR_GEN_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CAR_GEN_SEQ", sequenceName = "CAR_SEQ", allocationSize = 1)
    private Long id;
    private String carId;
    private String model;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Driver driver;
    @Enumerated(value = EnumType.STRING)
    private CarStatus status;


}
