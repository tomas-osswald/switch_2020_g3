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

}