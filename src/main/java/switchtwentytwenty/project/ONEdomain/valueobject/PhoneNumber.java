package switchtwentytwenty.project.ONEdomain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidPhoneNumberException;

import java.util.regex.Pattern;

public class PhoneNumber implements ValueObject<Integer> {

    private final static String INVALIDPHONE = "Phone number is not valid";
    private Integer number;

    public PhoneNumber(Integer number) {
        this.number = number;
        validateData();
    }

    private void validateData() {
        if (number != null) {
            checkNumber();
        }
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


    public boolean isNull() {
        boolean result = false;
        if (this.number == null) {
            result = true;
        }
        return result;
    }
}
