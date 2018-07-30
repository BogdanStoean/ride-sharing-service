package ro.esolutions.ridesharingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverModel {

    private String name;
    private Integer rating;
}