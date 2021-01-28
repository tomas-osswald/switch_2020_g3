package switchtwentytwenty.project.domain.model.user_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.sandbox.IBAN;

class IBANTest {
    String validIBAN = "PT50019300001050479170723";
    String validIBAN2 = "AL47 2121 1009 0000 0002 3569 8741";
    String spacedValidIBAN = "PT500 1930 0001 0504 7917 0723";
    String invalidIBAN = "PT50019300001050479270723";
    String nullIBAN = null;
    String blankIBAN = "    ";
    String emptyIBAN = "";


    @Test
    void testCreatingIBAN() {
        IBAN iban = new IBAN(validIBAN);
        Assertions.assertNotNull(iban);
    }

    @Test
    void testCreatingIBANNotThrows() {
        Assertions.assertDoesNotThrow(() -> {
            IBAN iban = new IBAN(validIBAN);
        });
    }

    @Test
    void testCreatingIBANSpaced() {
        Assertions.assertDoesNotThrow(() -> {
            IBAN iban = new IBAN(spacedValidIBAN);
        });
    }

    @Test
    void testCreatingIBANThrowsInvalidIBAN() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN iban = new IBAN(invalidIBAN);
        });
    }

    @Test
    void testCreatingIBANThrowsBlankIBAN() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN iban = new IBAN(blankIBAN);
        });
    }

    @Test
    void testCreatingIBANThrowsNullIBAN() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN iban = new IBAN(nullIBAN);
        });
    }

    @Test
    void testCreatingIBANThrowsEmptyIBAN() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IBAN iban = new IBAN(emptyIBAN);
        });
    }

    @Test
    void testWhiteSpaceTrimming() {
        IBAN iban = new IBAN(spacedValidIBAN);
        String expected = validIBAN;
        String result = iban.getIbanNumber();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testEqualsTrue() {
        IBAN iban = new IBAN(validIBAN);
        IBAN iban2 = new IBAN(spacedValidIBAN);
        Assertions.assertEquals(iban, iban2);
    }

    @Test
    void testEqualsTrueSame() {
        IBAN iban = new IBAN(validIBAN);
        Assertions.assertEquals(iban, iban);
    }

    @Test
    void testEqualsFalseDiffObjects() {
        EmailAddress email = new EmailAddress("test@gmail.com");
        IBAN iban = new IBAN(validIBAN);
        Assertions.assertNotEquals(iban, email);
    }

    @Test
    void testEqualsFalseDiferentNumbers() {
        IBAN iban = new IBAN(validIBAN);
        IBAN iban2 = new IBAN(validIBAN2);
        Assertions.assertNotEquals(iban, iban2);
    }
}