package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidPhoneNumberException;

public class PhoneNumber implements ValueObject {

    private String number;
    private final static String INVALIDPHONE = "Phone number is not valid";

    public PhoneNumber(String number) {
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
      return true;
    }
}
