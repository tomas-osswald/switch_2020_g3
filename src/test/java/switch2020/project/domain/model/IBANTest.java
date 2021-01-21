package switch2020.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IBANTest {
    String validIBAN = "PT50019300001050479170723";
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
}