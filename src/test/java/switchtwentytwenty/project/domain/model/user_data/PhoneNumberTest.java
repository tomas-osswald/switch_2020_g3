package switchtwentytwenty.project.domain.model.user_data;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.accounts.AccountData;

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
        PhoneNumber phoneNumber2 = new PhoneNumber(number);

        assertEquals(phoneNumber, phoneNumber2);
    }

    @Test
    void compareWithAnotherClass() {
        VatNumber vat = new VatNumber(123456789);
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);

        assertNotEquals(phoneNumber, vat);
        assertNotSame(phoneNumber, vat);
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

    @Test
    void testHashCodeEqualObjects() {
        Integer number = 957247231;
        PhoneNumber expected = new PhoneNumber(number);
        PhoneNumber result = new PhoneNumber(number);
        assertEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        Integer number = 957247231;
        Integer number2 = 957245231;
        PhoneNumber expected = new PhoneNumber(number);
        PhoneNumber result = new PhoneNumber(number2);
        assertNotEquals(result.hashCode(), expected.hashCode());
    }
}