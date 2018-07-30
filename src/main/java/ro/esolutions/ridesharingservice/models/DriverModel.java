package ro.esolutions.ridesharingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverModel {

    private Long id;
    @NotNull
    private String name;
    private Integer rating;
}
