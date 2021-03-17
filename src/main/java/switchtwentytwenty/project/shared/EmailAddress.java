package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;
import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import java.util.Objects;
import java.util.regex.Pattern;

public class EmailAddress implements ValueObject, ID {

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

    private boolean isValidEmail() {
        if (email == null)
            return false;
        if (email.isEmpty() || email.trim().length()==0)
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
