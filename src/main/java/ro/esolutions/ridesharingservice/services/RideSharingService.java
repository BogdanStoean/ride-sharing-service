package ro.esolutions.ridesharingservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.esolutions.ridesharingservice.exceptions.CarAlreadyExistsException;
import ro.esolutions.ridesharingservice.exceptions.CarNotFoundException;
import ro.esolutions.ridesharingservice.exceptions.NoCarAvailableException;
import ro.esolutions.ridesharingservice.models.CarModel;
import ro.esolutions.ridesharingservice.models.CarStatus;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class RideSharingService {

    private final Map<String, CarModel> cars = new ConcurrentHashMap<>();


    public CarModel registerCar(final CarModel car) {
        if (cars.get(car.getCarId()) == null) {
            return cars.put(car.getCarId(), car);
        } else {
            throw new CarAlreadyExistsException(car.getCarId());
        }
    }

    public CarModel checkCar(String carId) {
        if (cars.get(carId) != null) {
            return cars.get(carId);
        } else {
            throw new CarNotFoundException(carId);
        }

    }


    public CarModel getMeAnAvailableCar() {
        Optional<CarModel> optionalCar = cars.values().stream()
                .filter(car -> CarStatus.AVAILABLE.equals(car.getStatus()))
                .findAny();
        if (optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new NoCarAvailableException();
        }
    }

    @Scheduled(fixedRate = 500000)
    public void changeAllPendingCarsToAvailable() {
        log.info("SCHEDULED TASK");
    }

    @Async
    public void computeRideSharingTotalForOneDay() {
        log.info("ASYNC TASK STARTED");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("ASYNC TASK ENDED");
    }
}
