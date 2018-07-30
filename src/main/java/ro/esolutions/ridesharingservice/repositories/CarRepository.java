package ro.esolutions.ridesharingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.ridesharingservice.entities.Car;
import ro.esolutions.ridesharingservice.models.CarStatus;

import java.util.Optional;
import java.util.stream.Stream;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByCarId(String carId);

    Stream<Car> findByStatus(CarStatus carStatus);
}
