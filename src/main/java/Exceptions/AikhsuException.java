package Exceptions;

public class AikhsuException extends Exception{
    public AikhsuException(String message) {
        super(message);
    }

    public AikhsuException(String message, Throwable description) {
        super(message, description);
    }
}
