package switch2020.project.domain.model;

import java.math.BigInteger;
import java.util.Objects;

public class IBAN {

    private String ibanNumber;


    public IBAN(String iban) {
        if (validate(iban)) {
            this.ibanNumber = iban.replace(" ", "");
        } else {
            throw new IllegalArgumentException("Invalid IBAN number");
        }
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    private boolean validate(String iban) {
        if (iban == null)
            return false;
        if (iban.isEmpty() || iban.trim().length() == 0)
            return false;
        return checkIBAN(iban);
    }

    private boolean checkIBAN(String iban) {
        String trimmedIban = iban.replace(" ", "");
        BigInteger ibanToCheck = moveFirst4Characters(trimmedIban);
        return ibanToCheck.mod(BigInteger.valueOf(97)).equals(BigInteger.ONE);


    }

    private BigInteger moveFirst4Characters(String iban) {
        BigInteger rearrangedIBAN = BigInteger.valueOf(0);
        char[] temp = iban.toCharArray();
        for (int i = 4; i < iban.length(); i++) {
            rearrangedIBAN = rearrangedIBAN.multiply(BigInteger.TEN);
            if (getNumberFromChar(temp[i]).compareTo(BigInteger.valueOf(0)) != 0) {
                rearrangedIBAN = rearrangedIBAN.add(getNumberFromChar(temp[i]));
            }

        }
        for (int i = 0; i <= 3; i++) {
            rearrangedIBAN = rearrangedIBAN.multiply(BigInteger.TEN);
            if (getNumberFromChar(temp[i]).compareTo(BigInteger.valueOf(0)) != 0) {
                if (getNumberFromChar(temp[i]).toString().length() == 2) {
                    rearrangedIBAN = rearrangedIBAN.multiply(BigInteger.TEN);
                }
                rearrangedIBAN = rearrangedIBAN.add(getNumberFromChar(temp[i]));
            }
        }
        return rearrangedIBAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IBAN)) return false;
        IBAN that = (IBAN) o;
        return Objects.equals(ibanNumber, that.ibanNumber);
    }

    /**
     * Method to translate characters to its value
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     *
     * @param letter
     * @return int representing the value of the character
     * Adaptado de https://www.autenticacao.gov.pt/documents/
     */
    private BigInteger getNumberFromChar(char letter) {
        switch (letter) {
            case '0':
                return BigInteger.valueOf(0);
            case '1':
                return BigInteger.valueOf(1);
            case '2':
                return BigInteger.valueOf(2);
            case '3':
                return BigInteger.valueOf(3);
            case '4':
                return BigInteger.valueOf(4);
            case '5':
                return BigInteger.valueOf(5);
            case '6':
                return BigInteger.valueOf(6);
            case '7':
                return BigInteger.valueOf(7);
            case '8':
                return BigInteger.valueOf(8);
            case '9':
                return BigInteger.valueOf(9);
            case 'A':
                return BigInteger.valueOf(10);
            case 'B':
                return BigInteger.valueOf(11);
            case 'C':
                return BigInteger.valueOf(12);
            case 'D':
                return BigInteger.valueOf(13);
            case 'E':
                return BigInteger.valueOf(14);
            case 'F':
                return BigInteger.valueOf(15);
            case 'G':
                return BigInteger.valueOf(16);
            case 'H':
                return BigInteger.valueOf(17);
            case 'I':
                return BigInteger.valueOf(18);
            case 'J':
                return BigInteger.valueOf(19);
            case 'K':
                return BigInteger.valueOf(20);
            case 'L':
                return BigInteger.valueOf(21);
            case 'M':
                return BigInteger.valueOf(22);
            case 'N':
                return BigInteger.valueOf(23);
            case 'O':
                return BigInteger.valueOf(24);
            case 'P':
                return BigInteger.valueOf(25);
            case 'Q':
                return BigInteger.valueOf(26);
            case 'R':
                return BigInteger.valueOf(27);
            case 'S':
                return BigInteger.valueOf(28);
            case 'T':
                return BigInteger.valueOf(29);
            case 'U':
                return BigInteger.valueOf(30);
            case 'V':
                return BigInteger.valueOf(31);
            case 'W':
                return BigInteger.valueOf(32);
            case 'X':
                return BigInteger.valueOf(33);
            case 'Y':
                return BigInteger.valueOf(34);
            case 'Z':
                return BigInteger.valueOf(35);
        }
        throw new IllegalArgumentException("Invalid CC Number");
    }
}
