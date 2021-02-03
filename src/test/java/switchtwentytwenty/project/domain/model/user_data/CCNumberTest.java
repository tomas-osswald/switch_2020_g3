package switchtwentytwenty.project.domain.model.user_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
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

    @Test
    void CreateInValidCCNumberUnusedLetter() {
        String testCCNumber = "000000000BF4";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CCNumber testCC = new CCNumber(testCCNumber);
        });
    }

    @Test
    void testEquals_sameObject() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        CCNumber testTwo = testOne;
        Assertions.assertEquals(testOne, testTwo);
    }

    @Test
    void testEquals_differentObjectTypes() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        Date notCCNumber = new Date();
        Assertions.assertNotEquals(testOne, notCCNumber);
    }

    @Test
    void testEquals_sameCCNumber() {
        String testCCNumberOne = "000000000ZZ4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        String testCCNumber = "000000000ZZ4";
        CCNumber testTwo = new CCNumber(testCCNumber);
        Assertions.assertEquals(testOne, testTwo);
    }

    @Test
    void testEquals_differentCCNumber() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        String testCCNumber = "000000000ZZ4";
        CCNumber testTwo = new CCNumber(testCCNumber);
        Assertions.assertNotEquals(testOne, testTwo);
    }


    @Test
    void testHashCodeNotEquals() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        String testCCNumber = "000000000ZZ4";
        CCNumber testTwo = new CCNumber(testCCNumber);
        Assertions.assertNotEquals(testOne.hashCode(), testTwo.hashCode());
    }

    @Test
    void testHashCodeEquals() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        CCNumber testTwo = new CCNumber(testCCNumberOne);
        Assertions.assertEquals(testOne.hashCode(), testTwo.hashCode());
    }

    @Test
    void testHashCodeNotEqualsZero() {
        String testCCNumberOne = "000000000BC4";
        CCNumber testOne = new CCNumber(testCCNumberOne);
        Assertions.assertNotEquals(testOne.hashCode(), 0);
    }


}