package ro.esolutions.ridesharingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Driver {

    @Id
    @GeneratedValue(generator = "DRIVER_GEN_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DRIVER_GEN_SEQ", sequenceName = "DRIVER_SEQ", allocationSize = 1)
    private Long id;
    private String name;
    private Integer rating;
}
