package exceptions;

public class NoSuchRequestException extends Exception {

    public NoSuchRequestException() {
    }

    public NoSuchRequestException(String message) {
        super(message);
    }
}
