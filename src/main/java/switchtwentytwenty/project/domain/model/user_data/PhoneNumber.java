package switchtwentytwenty.project.domain.model.user_data;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneNumber {

    private final int phoneNumber;

    /********************** CONSTRUCTORS **********************/

    public PhoneNumber(Integer phoneNumber) {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    public boolean validate(Integer phoneNumber) {
        String regex = "\\d{9}";
        String phone = String.valueOf(phoneNumber);
        boolean test = Pattern.matches(regex,phone);
        if (phoneNumber == null){
            return false;
        } else return test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return this.phoneNumber == that.phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
