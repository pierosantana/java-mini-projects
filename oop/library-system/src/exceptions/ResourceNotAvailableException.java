package exceptions;

public class ResourceNotAvailableException extends RuntimeException {
    public ResourceNotAvailableException(String message) {
        super(message);
    }
}
