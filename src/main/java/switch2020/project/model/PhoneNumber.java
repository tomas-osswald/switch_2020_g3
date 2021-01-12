package switch2020.project.model;

import java.util.regex.Pattern;

public class PhoneNumber {

    private final int phoneNumber;

    /********************** CONSTRUCTORS **********************/

    public PhoneNumber(int phoneNumber) {
        if (!validate(phoneNumber))
            throw new IllegalArgumentException("Invalid Phone Number.");
        this.phoneNumber = phoneNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    public boolean validate(int phoneNumber) {
        String regex = "\\d{9}";
        String phone = String.valueOf(phoneNumber);
        boolean test = Pattern.matches(regex,phone);
        if (phoneNumber == 0){
            return false;
        } else if(!test) {
            return false;
        } else {
            return true;
        }
    }

}
