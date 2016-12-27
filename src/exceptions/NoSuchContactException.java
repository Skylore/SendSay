package exceptions;

public class NoSuchContactException extends Exception {
    public NoSuchContactException() {
    }

    public NoSuchContactException(String message) {
        super(message);
    }
}
