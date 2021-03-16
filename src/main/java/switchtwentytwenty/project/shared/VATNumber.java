package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidVATException;

public class VATNumber implements ValueObject {

    private final int vat;
    private final static String INVALIDVAT = "Invalid VAT";

    public VATNumber(int vat) {
        this.vat = vat;
        validateData();
    }

    private void validateData() {
        checkVatNumber();
    }

    private void checkVatNumber() {
        if(!isValidVAT())
            throw new InvalidVATException(INVALIDVAT);
    }

    private boolean isValidVAT() {
        return true;
    }
}
