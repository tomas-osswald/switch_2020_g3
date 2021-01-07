package switch2020.project.model;

import java.util.regex.Pattern;

public class EmailAddress {

    // Attributes
    private String email;

    // Constructors
    public EmailAddress(String email)
    {
        if (!validate(email))
            throw new IllegalArgumentException("Invalid Email Address.");
        this.email = email;
    }

    // Business Methods
    public String getEmail() {
        return email;
    }

    private boolean validate(String email) {
        if (email == null)
            return false;
        if (email.isEmpty() || email.isBlank())
            return false;
        // Check for other invalid criteria here

        //
        return checkFormat(email);
    }

    // Extracted from https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    private boolean checkFormat(String email) {
        String emailRegex = "[A-Z0-9a-z._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}
