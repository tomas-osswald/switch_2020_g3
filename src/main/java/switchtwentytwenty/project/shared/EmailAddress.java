package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidEmailException;

public class EmailAddress implements ValueObject {

    private String email;
    private final static String INVALIDEMAIL = "This Email is not valid";

    public EmailAddress(String email) {
        this.email = email;
        validateData();
    }

    private void validateData() {
        checkEmail();
    }

    private void checkEmail() {
        if(!isValidEmail())
            throw new InvalidEmailException(INVALIDEMAIL);
    }

    // Validação com lógica de negócio
    private boolean isValidEmail() {
        return true;
    }

}
