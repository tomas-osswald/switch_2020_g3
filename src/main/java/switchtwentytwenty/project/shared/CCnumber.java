package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidCCException;
import switchtwentytwenty.project.exceptions.InvalidCharException;
import switchtwentytwenty.project.util.NumberFromCharHelper;

import java.util.Objects;

public class CCnumber implements ValueObject {

    private final static String INVALIDCC = "CC is not valid";
    private String ccNumber;


    public CCnumber(String ccNumber) {
        validateData(ccNumber);
        String finalCC = ccNumber.toUpperCase().replaceAll("\\s", "");
        this.ccNumber = finalCC;
    }

    private void validateData(String ccNumber) {
        if (!validateCC(ccNumber)) {
            throw new InvalidCCException(INVALIDCC);
        }
    }

    /**
     * Method to validate a ID Number of the Portuguese Cartão do Cidadão
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     *
     * @return true if ID valid
     */

    //TODO: Modularizar posteriormente.
    private boolean validateCC(String ccNumber) {
        int sum = 0;
        int value;
        boolean secondDigit = false;
        if (ccNumber == null || ccNumber.trim().
                length() == 0 || ccNumber.isEmpty()) {
            return false;
        }
        if (ccNumber.replaceAll("\\s", "").length() != 12)
            return false;
        String ccNumberUpper = ccNumber.toUpperCase().replaceAll("\\s", "");
        for (
                int i = ccNumberUpper.length() - 1;
                i >= 0; --i) {
            try {
                value = NumberFromCharHelper.getNumberFromChar(ccNumberUpper.charAt(i));
            } catch (InvalidCharException e) {
                return false;
            }
            if (secondDigit) {
                value *= 2;
                if (value > 9)
                    value -= 9;
            }
            sum += value;
            secondDigit = !secondDigit;
        }
        return (sum % 10) == 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CCnumber)) return false;
        CCnumber that = (CCnumber) o;
        return Objects.equals(ccNumber, that.ccNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccNumber);
    }


}
