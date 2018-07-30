package ro.esolutions.ridesharingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.ridesharingservice.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
