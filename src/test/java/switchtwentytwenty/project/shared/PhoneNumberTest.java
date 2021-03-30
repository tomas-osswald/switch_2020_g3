package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.exceptions.InvalidPhoneNumberException;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    final Integer VALIDPHONE = 999999999;
    PhoneNumber phone;


    @DisplayName("Test the creation of a valid PhoneNumber")
    @Test
    void shouldNotThrowCreateValidPhoneNumber(){
        assertDoesNotThrow(()->phone = new PhoneNumber(VALIDPHONE));
    }

    @DisplayName("Test the creation of a null PhoneNumber")
    @Test
    void shouldNotThrowCreateNullPhoneNumber(){
        assertDoesNotThrow(()->phone = new PhoneNumber(null));
    }


    @DisplayName("Test that a negative, zero and boundary values throw exceptions")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 99999999,1000000000})
    void shouldThrowBoundaryValuesPhoneNumber(int value){
        assertThrows(InvalidPhoneNumberException.class, ()-> phone = new PhoneNumber(value) );
    }

}