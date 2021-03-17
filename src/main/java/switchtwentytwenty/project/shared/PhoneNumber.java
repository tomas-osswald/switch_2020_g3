package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidPhoneNumberException;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneNumber implements ValueObject {

    private int number;
    private final static String INVALIDPHONE = "Phone number is not valid";

    public PhoneNumber(int number) {
        this.number = number;
        validateData();
    }

    private void validateData() {
        checkNumber();
    }

    private void checkNumber() {
        if (!isPhoneNumberValid())
            throw new InvalidPhoneNumberException(INVALIDPHONE);
    }

    // Definir lógica de negócio
    private boolean isPhoneNumberValid() {
        boolean result;
        String regex = "\\d{9}";
        String phoneNumb = String.valueOf(number);
        boolean test = Pattern.matches(regex, phoneNumb);
        if (phoneNumb.length() == 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }


}
