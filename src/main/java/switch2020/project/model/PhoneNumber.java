package switch2020.project.model;

import java.util.regex.Pattern;
import java.util.Objects;

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
        } else if(!test) {
            return false;
        } else {
            return true;
        }
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
