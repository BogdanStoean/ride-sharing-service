package ro.esolutions.ridesharingservice.resources;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.ridesharingservice.models.CarModel;
import ro.esolutions.ridesharingservice.services.RideSharingService;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Slf4j
public class CarResource {

    private final RideSharingService rideSharingService;

//    public CarResource(RideSharingService rideSharingService) {
//        this.rideSharingService = Objects.requireNonNull(rideSharingService, "rideSharingService must not be null");
//    }

    @PostMapping
    public ResponseEntity<CarModel> registerCar(@RequestBody @Valid final CarModel car) {
        return ResponseEntity.ok(rideSharingService.registerCar(car));
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<CarModel> checkCar(@PathVariable("car_id") final String carId) {
        log.info("Checking the car ID " + carId);
        return ResponseEntity.ok(rideSharingService.checkCar(carId));
    }

    @GetMapping("/available")
    public ResponseEntity<CarModel> getAvailableCar() {
        return ResponseEntity.ok(rideSharingService.getMeAnAvailableCar());
    }


    @PutMapping("/startDailyJob")
    public ResponseEntity<Object> startDailyComputingJob() {
        rideSharingService.computeRideSharingTotalForOneDay();
        return ResponseEntity.ok("STARTED");
    }


}
