package ro.esolutions.ridesharingservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.ridesharingservice.models.Car;
import ro.esolutions.ridesharingservice.services.RideSharingService;

import java.util.Objects;

@RestController
@RequestMapping("/cars")
public class CarResource {

    private final RideSharingService rideSharingService;

    public CarResource(RideSharingService rideSharingService) {
        this.rideSharingService = Objects.requireNonNull(rideSharingService, "rideSharingService must not be null");
    }

    @PostMapping
    public ResponseEntity<Car> registerCar(@RequestBody final Car car) {
        return ResponseEntity.ok(rideSharingService.registerCar(car));
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<Car> checkCar(@PathVariable("car_id") final String carId) {
        return ResponseEntity.ok(rideSharingService.checkCar(carId));
    }

    @GetMapping("/available")
    public ResponseEntity<Car> getAvailableCar() {
        return ResponseEntity.ok(rideSharingService.getMeAnAvailableCar());
    }


}
