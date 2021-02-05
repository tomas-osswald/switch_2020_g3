package switchtwentytwenty.project.domain.model.user_data;

import java.util.Objects;

public class CCNumber {

    private final String ccNumberString;

    public CCNumber(String ccNumberString) {

        if (!validateNumber(ccNumberString)) {
            throw new IllegalArgumentException("Invalid CC Number");
        }
        this.ccNumberString = ccNumberString.toUpperCase();

    }

    public String getCcNumberString() {
        return ccNumberString;
    }

    /**
     * Method to validate a ID Number of the Portuguese Cartão do Cidadão
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     *
     * @param ccNumber
     * @return true if ID valid
     */

    private boolean validateNumber(String ccNumber) {
        int sum = 0;
        boolean secondDigit = false;
        if (ccNumber == null || ccNumber.trim().length() == 0 || ccNumber.isEmpty()) {
            throw new IllegalArgumentException("CC Number is blank or empty");
        }
        if (ccNumber.length() != 12)
            throw new IllegalArgumentException("Invalid CC Number size");
        String ccNumberUpper = ccNumber.toUpperCase();
        for (int i = ccNumberUpper.length() - 1; i >= 0; --i) {
            int value = getNumberFromChar(ccNumberUpper.charAt(i));
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

    /**
     * Method to translate characters to its value
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     *
     * @param letter
     * @return int representing the value of the character
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     */
    private int getNumberFromChar(char letter) {
        switch (letter) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'V':
                return 31;
            case 'W':
                return 32;
            case 'X':
                return 33;
            case 'Y':
                return 34;
            case 'Z':
                return 35;
            default:
                throw new IllegalArgumentException("Invalid CC Number");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CCNumber)) return false;
        CCNumber that = (CCNumber) o;
        return Objects.equals(ccNumberString, that.ccNumberString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccNumberString);
    }
}
