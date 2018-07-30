package ro.esolutions.ridesharingservice.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.ridesharingservice.entities.Driver;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.repositories.DriverRepository;
import ro.esolutions.ridesharingservice.services.DriverService;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverResource {

    private final DriverService driverService;
    private final DriverRepository driverRepository;

    @PostMapping
    public ResponseEntity<DriverModel> addDriver(@RequestBody DriverModel driverModel) {
        return ResponseEntity.ok(driverService.addDriver(driverModel));
    }

    @GetMapping("/byPage")
    public List<Driver> driversByPage(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return driverRepository.findAllByNativeQuery(PageRequest.of(page, size)).getContent();
    }
}
