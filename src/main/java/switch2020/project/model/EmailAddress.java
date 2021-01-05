package main.java.switch2020.project.model;

import java.util.regex.Pattern;

public class EmailAddress {

    private String email;

    /********************** CONSTRUCTORS **********************/

    public EmailAddress(String email)
    {
        if (!validate(email))
            throw new IllegalArgumentException("Invalid Email Address.");
        this.email = email;
    }

    /********************** GETTERS AND SETTERS **********************/

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
    private boolean checkFormat(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}
