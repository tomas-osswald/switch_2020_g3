package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void CreatePhone_Null(){
        assertThrows(IllegalArgumentException.class,()-> new PhoneNumber(null));
    }

    @Test
    void CreatePhone_IncorrectNumbers(){
        assertThrows(IllegalArgumentException.class,()-> new PhoneNumber(12345678));
    }

    @Test
    void CreatePhone_Valid(){
        int number = 919988877;
        PhoneNumber phone = new PhoneNumber(number);
        assertTrue(phone.validate(number));
    }

    @Test
    void compareSamePhone() {
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);

        assertSame(phoneNumber, phoneNumber);
        assertEquals(phoneNumber, phoneNumber);
    }

    @Test
    void compareWithAnotherClass() {
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);

        assertNotEquals(phoneNumber, number);
        assertNotSame(phoneNumber, number);
    }

    @Test
    void compareTwoInstanceOfPhoneNumber() {
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);

        Integer number2 = 957247231;
        PhoneNumber phoneNumber2 = new PhoneNumber(number2);

        assertNotSame(phoneNumber, phoneNumber2);
        assertEquals(phoneNumber, phoneNumber2);
    }

    @Test
    void compareTwoInstanceOfPhoneNumberDiferentNumber() {
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);

        Integer number2 = 957245231;
        PhoneNumber phoneNumber2 = new PhoneNumber(number2);

        assertNotSame(phoneNumber, phoneNumber2);
        assertNotEquals(phoneNumber, phoneNumber2);
    }
}