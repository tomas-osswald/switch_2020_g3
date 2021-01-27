package switchtwentytwenty.project.domain.model.user_data;

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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });

    }

    @Test
    void CreateInValidCCNumber_WrongLenght() {
        String testCCNumber = "0000000000ZZ4";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_Null() {
        String testCCNumber = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_Blank() {
        String testCCNumber = "      ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateInValidCCNumber_WrongEmpty() {
        String testCCNumber = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber test = new CCNumber(testCCNumber);
        });
    }

    @Test
    void CreateValidCCNumberBC() {
        String testCCNumber = "000000000BC4";
        try {
            CCNumber test = new CCNumber(testCCNumber);
        } catch (Exception e) {
            fail("Invalid CC Number");
        }
    }

}