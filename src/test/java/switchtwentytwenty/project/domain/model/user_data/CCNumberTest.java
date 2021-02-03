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
        String test2 = "134295072ZW0";
        String test3 = "180925580ZY9";
        String test4 = "164143653ZX6";
        String test5 = "147563216ZX8";
        String test6 = "163047960ZZ0";
        String test7 = "164275746ZZ4";
        String test8 = "127123911ZY7";
        String test9 = "162241135ZZ5";
        String test10 = "155301527ZX8";
        String test11 = "121713253ZW7";

        try {
            CCNumber test = new CCNumber(testCCNumber);
            CCNumber cc2 = new CCNumber(test2);
            CCNumber cc3 = new CCNumber(test3);
            CCNumber cc4 = new CCNumber(test4);
            CCNumber cc5 = new CCNumber(test5);
            CCNumber cc6 = new CCNumber(test6);
            CCNumber cc7 = new CCNumber(test7);
            CCNumber cc8 = new CCNumber(test8);
            CCNumber cc9 = new CCNumber(test9);
            CCNumber cc10 = new CCNumber(test10);
            CCNumber cc11 = new CCNumber(test11);
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