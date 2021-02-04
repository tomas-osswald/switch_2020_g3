package switchtwentytwenty.project.domain.model.user_data;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneNumber {

    private final int phone;

    /********************** CONSTRUCTORS **********************/

    public PhoneNumber(Integer phone) {
        if (!validate(phone))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phone = phone;
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
        return this.phone == that.phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
}
