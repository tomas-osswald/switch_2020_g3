package switch2020.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.fail;

class CCNumberTest {

    @Test
    void CreateValidCCNumber() {
        String testCCNumber = "000000000ZZ4";
        try {
            CCNumber test = new CCNumber(testCCNumber);
        } catch (Exception e) {
            fail("Invalid CC Number");
        }
    }

    @Test
    void CreateInValidCCNumber() throws InvalidPropertiesFormatException {
        String testCCNumber = "111111111111";
        CCNumber test = new CCNumber(testCCNumber);
        String expected = null;
        Assertions.assertEquals(expected,test.getCcNumber());

    }

    @Test
    void CreateInValidCCNumber_WrongLenght() {
        String testCCNumber = "0000000000ZZ4";
        Assertions.assertThrows(InvalidPropertiesFormatException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_Null() {
        String testCCNumber = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_Blank() {
        String testCCNumber = "      ";
        Assertions.assertThrows(InvalidPropertiesFormatException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_WrongEmpty() {
        String testCCNumber = "";
        Assertions.assertThrows(InvalidPropertiesFormatException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }
}