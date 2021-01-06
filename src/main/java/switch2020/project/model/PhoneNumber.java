package main.java.switch2020.project.model;

public class PhoneNumber {
    private final int phoneNumber;

    /********************** CONSTRUCTORS **********************/

    public PhoneNumber(int phoneNumber) {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validate(int phoneNumber) {
        if (phoneNumber == 0)
            return false;
        // Check for other invalid criteria here
        return true;
    }
}
