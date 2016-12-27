package exceptions;

public class BannedUserException extends Exception {
    public BannedUserException() {
    }

    public BannedUserException(String message) {
        super(message);
    }
}
