package exceptions;

public class BookedListNameException extends Exception {
    public BookedListNameException() {
    }

    public BookedListNameException(String message) {
        super(message);
    }
}
