package ro.esolutions.ridesharingservice.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String carId) {
        super("Car with ID " + carId + "  does not exist");
    }
}
