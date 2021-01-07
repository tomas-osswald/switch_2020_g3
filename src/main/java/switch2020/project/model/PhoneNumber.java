package switch2020.project.model;

public class PhoneNumber {

    // Attributes
    private final String phoneNumber;

    // Constructors
    public PhoneNumber(String phoneNumber)
    {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    // Business Methods
    private boolean validate(String phoneNumber) {
        if (phoneNumber == null)
            return false;
        if (phoneNumber.isEmpty() || phoneNumber.isBlank())
            return false;
        // Check for other invalid criteria here

        return true;
    }
}
