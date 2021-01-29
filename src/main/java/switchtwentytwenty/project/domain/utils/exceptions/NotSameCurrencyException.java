package switchtwentytwenty.project.domain.utils.exceptions;

public class NotSameCurrencyException extends RuntimeException {

    public NotSameCurrencyException() {
        super();
    }

    public NotSameCurrencyException(String message) {
        super(message);
    }
}
