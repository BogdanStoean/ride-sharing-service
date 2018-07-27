package ro.esolutions.ridesharingservice.exceptions;

public class NoCarAvailableException extends RuntimeException {
    public NoCarAvailableException() {
        super("There's no ride for you my friend! Try again later!");
    }
}
