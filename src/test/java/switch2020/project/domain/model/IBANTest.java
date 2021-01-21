package switch2020.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IBANTest {
    String validIBAN = "PT50019300001050479170723";
    String invalidIBAN = "";

    @Test
    void testCreatingIBAN() {
        IBAN iban = new IBAN(validIBAN);
        Assertions.assertNotNull(iban);
    }
}