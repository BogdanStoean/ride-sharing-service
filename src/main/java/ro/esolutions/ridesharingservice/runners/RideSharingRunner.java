package ro.esolutions.ridesharingservice.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.esolutions.ridesharingservice.models.CarModel;
import ro.esolutions.ridesharingservice.models.CarStatus;
import ro.esolutions.ridesharingservice.models.DriverModel;
import ro.esolutions.ridesharingservice.services.RideSharingService;

import java.util.Objects;
import java.util.stream.IntStream;

@Component
public class RideSharingRunner implements CommandLineRunner {

    private final RideSharingService rideSharingService;

    public RideSharingRunner(final RideSharingService rideSharingService) {
        this.rideSharingService = Objects.requireNonNull(rideSharingService, "rideSharingService must not be null");
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.rangeClosed(1, 10).asLongStream().forEach(i -> {
            rideSharingService.registerCar(
                    CarModel
                            .builder()
                            .driver(DriverModel.builder().name("driver" + i).rating((int) i % 5).build())
                            .status(CarStatus.AVAILABLE)
                            .carId(i + "")
                            .model("model" + i)
                            .build());
        });

    }


}
