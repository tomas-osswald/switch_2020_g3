package main.java.switch2020.project.model;

public class PhoneNumber {
    private final Integer phoneNumber;

    /********************** CONSTRUCTORS **********************/

    public PhoneNumber(Integer phoneNumber) {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validate(Integer phoneNumber) {
        if (phoneNumber == null)
            return false;
        // Check for other invalid criteria here
        return true;
    }
}
