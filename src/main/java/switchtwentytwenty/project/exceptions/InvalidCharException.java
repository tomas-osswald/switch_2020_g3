package switchtwentytwenty.project.exceptions;

import java.io.Serializable;

public class InvalidCharException extends IllegalStateException {
    public InvalidCharException(String errorMessage) {
        super(errorMessage);
    }
}