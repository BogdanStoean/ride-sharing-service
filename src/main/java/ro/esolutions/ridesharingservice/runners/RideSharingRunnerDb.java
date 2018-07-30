package ro.esolutions.ridesharingservice.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.esolutions.ridesharingservice.entities.Car;
import ro.esolutions.ridesharingservice.entities.Driver;
import ro.esolutions.ridesharingservice.models.CarModel;
import ro.esolutions.ridesharingservice.models.CarStatus;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.repositories.CarRepository;
import ro.esolutions.ridesharingservice.services.RideSharingService;

import java.util.Objects;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class RideSharingRunnerDb implements CommandLineRunner {

    private final CarRepository carRepository;


    @Override
    public void run(String... args) throws Exception {
        IntStream.rangeClosed(1, 10).asLongStream().forEach(i -> {
            carRepository.save(
                    Car
                            .builder()
                            .driver(Driver.builder().name("driver" + i).rating((int) i % 5).build())
                            .status(CarStatus.AVAILABLE)
                            .carId(i + "")
                            .model("model" + i)
                            .build());
        });

    }


}
