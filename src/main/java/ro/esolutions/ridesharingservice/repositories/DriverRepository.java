package ro.esolutions.ridesharingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.ridesharingservice.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
