package exceptions;

public class BookedLoginException extends Exception {

    public BookedLoginException() {
    }

    public BookedLoginException(String message) {
        super(message);
    }
}
