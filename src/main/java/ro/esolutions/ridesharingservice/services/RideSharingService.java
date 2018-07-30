package ro.esolutions.ridesharingservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.esolutions.ridesharingservice.entities.Car;
import ro.esolutions.ridesharingservice.entities.Driver;
import ro.esolutions.ridesharingservice.exceptions.CarAlreadyExistsException;
import ro.esolutions.ridesharingservice.exceptions.CarNotFoundException;
import ro.esolutions.ridesharingservice.exceptions.NoCarAvailableException;
import ro.esolutions.ridesharingservice.models.CarModel;
import ro.esolutions.ridesharingservice.models.CarStatus;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.repositories.CarRepository;
import ro.esolutions.ridesharingservice.repositories.DriverRepository;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RideSharingService {

    private final CarRepository carRepository;
    private final DriverRepository driverRepository;

//    private final Map<String, CarModel> cars = new ConcurrentHashMap<>();


    public CarModel registerCar(final CarModel carModel) {
        Optional<Car> carOptional = carRepository.findByCarId(carModel.getCarId());

        if (!carOptional.isPresent()) {
            Car carSaved = carRepository.save(Car.builder()
                    .driver(getDriverIfExists(carModel.getDriver()))
                    .model(carModel.getModel())
                    .status(carModel.getStatus())
                    .carId(carModel.getCarId()).build());

            return CarModel.builder().carId(carSaved.getCarId()).build();
        } else {
            throw new CarAlreadyExistsException(carModel.getCarId());
        }
    }

    private Driver getDriverIfExists(DriverModel driverModel) {
        return driverRepository.findById(driverModel.getId())
                .orElseGet(() -> Driver.builder().rating(0).name(driverModel.getName()).build());
    }

    public CarModel checkCar(String carId) {
        final Optional<Car> carOptional = carRepository.findByCarId(carId);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            return CarModel.builder().carId(car.getCarId()).build();
        } else {
            throw new CarNotFoundException(carId);
        }

    }


    public CarModel getMeAnAvailableCar() {
        Optional<Car> optionalCar = carRepository.findByStatus(CarStatus.AVAILABLE).findAny();
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            return CarModel.builder().carId(car.getCarId()).build();
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
