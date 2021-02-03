package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class IBANTest {

    @Test
    void IBANNumberTest_InvalidVerificationDigitsOne() {

        String ibanString = "GB94BARC20201530093459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_ValidIBAN() {

        String ibanString = "GB94BARC20201530078456";
        IBAN ibanNumber = new IBAN(ibanString);

        Assertions.assertNotNull(ibanNumber);

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test2() {

        String ibanString = "GB94DEFH20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test3() {

        String ibanString = "GB94IJKL20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test4() {

        String ibanString = "GB94MNOP20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test5() {

        String ibanString = "GB94QRST20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test6() {

        String ibanString = "GB94UVWX20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void IBANNumberTest_InvalidIBAN_Test7() {

        String ibanString = "GB94AYZ-20201530078459";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN ibanNumber = new IBAN(ibanString);
        });

    }

    @Test
    void getIbanNumber() {
        String ibanString = "GB94BARC20201530078456";
        IBAN ibanNumber = new IBAN(ibanString);

        String result = ibanNumber.getIbanNumber();

        Assertions.assertEquals(ibanString, result);
    }

    @Test
    void testEquals_same() {
        String ibanString = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanString);
        IBAN ibanNumberTwo = ibanNumberOne;

        Assertions.assertEquals(ibanNumberOne, ibanNumberTwo);
    }

    @Test
    void testEquals_differentObjectTypes() {
        String ibanString = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanString);
        Date notIban = new Date();

        Assertions.assertNotEquals(ibanNumberOne, notIban);
    }

    @Test
    void testEquals_sameContent() {
        String ibanString = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanString);
        IBAN ibanNumberTwo = new IBAN(ibanString);

        Assertions.assertEquals(ibanNumberOne, ibanNumberTwo);
    }

    @Test
    void testEquals_differentContent() {
        String ibanStringOne = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanStringOne);
        String ibanStringTwo = "GB94UYZX20201530078459";
        IBAN ibanNumberTwo = new IBAN(ibanStringTwo);

        Assertions.assertNotEquals(ibanNumberOne, ibanNumberTwo);
    }


    @Test
    void testHashCodeNotEquals() {
        String ibanStringOne = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanStringOne);
        String ibanStringTwo = "GB94UYZX20201530078459";
        IBAN ibanNumberTwo = new IBAN(ibanStringTwo);

        assertNotEquals(ibanNumberOne.hashCode(), ibanNumberTwo.hashCode());

    }

    @Test
    void testHashCodeEquals() {
        String ibanStringOne = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanStringOne);
        IBAN ibanNumberTwo = new IBAN(ibanStringOne);

        assertEquals(ibanNumberOne.hashCode(), ibanNumberTwo.hashCode());

    }

    @Test
    void testHashCodeNotZero() {
        String ibanStringOne = "GB94BARC20201530078456";
        IBAN ibanNumberOne = new IBAN(ibanStringOne);

        assertNotEquals(ibanNumberOne.hashCode(), 0);

    }
}