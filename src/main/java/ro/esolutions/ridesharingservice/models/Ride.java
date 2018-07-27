package ro.esolutions.ridesharingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ride {
    private String client;
    private Car car;
    private Location source;
    private Location destination;
    private LocalDateTime sourceTime;
    private LocalDateTime destTime;
    private BigDecimal cost;
}
