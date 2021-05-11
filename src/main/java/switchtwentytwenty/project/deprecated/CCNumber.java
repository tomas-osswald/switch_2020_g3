package switchtwentytwenty.project.deprecated;

import switchtwentytwenty.project.domain.valueobject.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidCCException;
import switchtwentytwenty.project.exceptions.InvalidCharException;

import java.util.Objects;

/**
 * @deprecated The CCNumber value object is no longer used in the application
 */
@Deprecated
public class CCNumber implements ValueObject {

    private static final String INVALIDCCMESSAGE = "CC is not valid";
    private final String cc;


    public CCNumber(String ccNumber) {
        validateData(ccNumber);
        String finalCCNumber = ccNumber.toUpperCase().replaceAll("\\s", "");
        this.cc = finalCCNumber.trim();
    }

    private void validateData(String ccNumber) {
        if (!validateCC(ccNumber)) {
            throw new InvalidCCException(INVALIDCCMESSAGE);
        }
    }

    /**
     * Method to validate a ID Number of the Portuguese Cartão do Cidadão
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     *
     * @return true if ID valid
     */

    private boolean validateCC(String ccNumber) {
        int sum = 0;
        int value;
        boolean secondDigit = false;
        if (ccNumber == null || ccNumber.trim().length() == 0) {
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
        if (!(o instanceof CCNumber)) return false;
        CCNumber that = (CCNumber) o;
        return Objects.equals(cc, that.cc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cc);
    }

}
