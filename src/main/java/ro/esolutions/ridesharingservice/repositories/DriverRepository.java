package ro.esolutions.ridesharingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.ridesharingservice.entities.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findById(Long id);

}
