package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidEmailException;

import java.util.Objects;
import java.util.regex.Pattern;

public class EmailAddress implements ValueObject {


    private String email;

    public EmailAddress(String email) {
        this.email = email;
        validateData();
    }

    @Override
    public String toString() {
        return this.email;
    }

    private void validateData() {
        checkEmail();
    }

    private void checkEmail() {
        String INVALIDEMAIL = "This Email is not valid";
        if (!isValidEmail())
            throw new InvalidEmailException(INVALIDEMAIL);
    }

    private boolean isValidEmail() {
        if (email == null)
            return false;
        if (email.isEmpty() || email.trim().length() == 0)
            return false;
        String emailRegex = "[A-Z0-9a-z._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}
