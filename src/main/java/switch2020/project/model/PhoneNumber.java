package switch2020.project.model;

public class PhoneNumber {
    private final String phoneNumber;

    public PhoneNumber(String phoneNumber)
    {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    private boolean validate(String phoneNumber) {
        if (phoneNumber == null)
            return false;
        if (phoneNumber.isEmpty() || phoneNumber.isBlank())
            return false;
        // Check for other invalid criteria here

        return true;
    }
}
