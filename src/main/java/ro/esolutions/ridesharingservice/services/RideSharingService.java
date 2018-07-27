package ro.esolutions.ridesharingservice.services;

import org.springframework.stereotype.Service;
import ro.esolutions.ridesharingservice.exceptions.CarAlreadyExistsException;
import ro.esolutions.ridesharingservice.exceptions.CarNotFoundException;
import ro.esolutions.ridesharingservice.exceptions.NoCarAvailableException;
import ro.esolutions.ridesharingservice.models.Car;
import ro.esolutions.ridesharingservice.models.CarStatus;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RideSharingService {

    private final Map<String, Car> cars = new ConcurrentHashMap<>();


    public Car registerCar(final Car car) {
        if (cars.get(car.getCarId()) == null) {
            return cars.put(car.getCarId(), car);
        } else {
            throw new CarAlreadyExistsException(car.getCarId());
        }
    }

    public Car checkCar(String carId) {
        if (cars.get(carId) != null) {
            return cars.get(carId);
        } else {
            throw new CarNotFoundException(carId);
        }

    }


    public Car getMeAnAvailableCar() {
        Optional<Car> optionalCar = cars.values().stream()
                .filter(car -> CarStatus.AVAILABLE.equals(car.getStatus()))
                .findAny();
        if (optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new NoCarAvailableException();
        }
    }
}
