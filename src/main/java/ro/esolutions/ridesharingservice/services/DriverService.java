package ro.esolutions.ridesharingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.ridesharingservice.entities.Driver;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.repositories.DriverRepository;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;


    public DriverModel addDriver(DriverModel driverModel) {
        Driver driver = driverRepository.save(
                Driver.builder().name(driverModel.getName()).rating(0).build());

        return DriverModel.builder()
                .name(driver.getName())
                .id(driver.getId())
                .rating(driver.getRating())
                .build();
    }


}
