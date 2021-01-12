package switch2020.project.model;

import java.util.InvalidPropertiesFormatException;

public class CCNumber {

    private String ccNumber;

    public CCNumber(String ccNumber) throws InvalidPropertiesFormatException {

        if (validateNumber(ccNumber.toUpperCase())) {
            this.ccNumber = ccNumber.toUpperCase();
        }

    }

    public String getCcNumber() {
        return ccNumber;
    }

    private boolean validateNumber(String ccNumber) throws InvalidPropertiesFormatException {
        int sum = 0;
        boolean secondDigit = false;
        if (ccNumber.length() != 12)
            throw new InvalidPropertiesFormatException("Invalid CC Number size");
        for (int i = ccNumber.length() - 1; i >= 0; --i) {
            int value = GetNumberFromChar(ccNumber.charAt(i));
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

    public int GetNumberFromChar(char letter) throws InvalidPropertiesFormatException {
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
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            case 'H':
                return 17;
            case 'I':
                return 18;
            case 'J':
                return 19;
            case 'K':
                return 20;
            case 'L':
                return 21;
            case 'M':
                return 22;
            case 'N':
                return 23;
            case 'O':
                return 24;
            case 'P':
                return 25;
            case 'Q':
                return 26;
            case 'R':
                return 27;
            case 'S':
                return 28;
            case 'T':
                return 29;
            case 'U':
                return 30;
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
        }
        throw new InvalidPropertiesFormatException("Invalid CC Number");
    }
}
