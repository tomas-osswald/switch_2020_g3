package switchtwentytwenty.project.exceptions;

import java.io.Serializable;

public class InvalidCharException extends IllegalStateException implements Serializable {
    public InvalidCharException(String errorMessage) {
        super(errorMessage);
    }
}