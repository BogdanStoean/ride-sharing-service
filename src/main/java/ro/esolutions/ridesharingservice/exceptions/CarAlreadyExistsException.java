package ro.esolutions.ridesharingservice.exceptions;

public class CarAlreadyExistsException extends RuntimeException {
    public CarAlreadyExistsException(String carId) {
        super(carId);
    }
}
