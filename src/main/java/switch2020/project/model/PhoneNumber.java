package switch2020.project.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phoneNumber == that.phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
