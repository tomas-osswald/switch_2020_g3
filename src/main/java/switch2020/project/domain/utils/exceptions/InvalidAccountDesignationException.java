package switch2020.project.domain.utils.exceptions;

public class InvalidAccountDesignationException extends RuntimeException {

    public InvalidAccountDesignationException() {
        super();
    }

    public InvalidAccountDesignationException(String message) {
        super(message);
    }
}
