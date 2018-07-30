package ro.esolutions.ridesharingservice.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.services.DriverService;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverResource {

    private final DriverService driverService;

    @PostMapping
    public ResponseEntity<DriverModel> addDriver(@RequestBody DriverModel driverModel){
        return ResponseEntity.ok(driverService.addDriver(driverModel));
    }
}
