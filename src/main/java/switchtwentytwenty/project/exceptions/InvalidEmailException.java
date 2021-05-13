package switchtwentytwenty.project.exceptions;

public class InvalidEmailException extends IllegalStateException {

    public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidEmailException() {
        super("This Email is not valid");
    }
}
