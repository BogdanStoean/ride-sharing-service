package ro.esolutions.ridesharingservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.esolutions.ridesharingservice.entities.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findById(Long id);

    @Query(value = "SELECT * FROM driver", countQuery = "SELECT count(1) FROM driver", nativeQuery = true)
    Page<Driver> findAllByNativeQuery(Pageable pageable);

}
