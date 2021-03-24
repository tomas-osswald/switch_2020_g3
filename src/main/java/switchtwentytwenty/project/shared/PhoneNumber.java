package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidPhoneNumberException;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhoneNumber implements ValueObject<Integer> {

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
        String regex = "\\d{9}";
        String phoneNumb = String.valueOf(number);
        return Pattern.matches(regex, phoneNumb);
    }


}
