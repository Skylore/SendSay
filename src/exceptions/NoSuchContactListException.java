package exceptions;

public class NoSuchContactListException extends Exception {
    public NoSuchContactListException() {
    }

    public NoSuchContactListException(String message) {
        super(message);
    }
}
