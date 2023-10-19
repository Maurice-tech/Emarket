package Exceptions;

public class ThrowMyCustomException extends RuntimeException {
    public ThrowMyCustomException(String message) {
        super(message);
    }
}

