package ro.esolutions.ridesharingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.esolutions.ridesharingservice.models.CarModel;

//@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 5000)
    public void checkCars() {
        restTemplate.getForEntity("http://localhost:8080/cars/1", CarModel.class);
    }
}
