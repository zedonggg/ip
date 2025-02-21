package exceptions;

/**
 * A custom exception class for the Aikhsu application, used to handle application-specific errors.
 * Extends the standard Exception class to provide tailored error messaging.
 */
public class AikhsuException extends Exception {
    /**
     * Constructs an AikhsuException with the specified error message.
     *
     * @param message The error message describing the exception.
     */
    public AikhsuException(String message) {
        super(message);
    }

    /**
     * Constructs an AikhsuException with the specified error message and cause.
     *
     * @param message     The error message describing the exception.
     * @param description The underlying cause of the exception (a Throwable object).
     */
    public AikhsuException(String message, Throwable description) {
        super(message, description);
    }
}
