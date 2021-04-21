package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {
    final String VALIDBIRTHDATE = "01/03/2021";

    @DisplayName("Valid Birthdate construction")
    @Test
    @Tag("US010")
    void shouldNotThrowCreateValidBirthDate(){
        assertDoesNotThrow(()-> new BirthDate(VALIDBIRTHDATE));
    }


    @DisplayName("Invalid Birthdate construction")
    @Tag("US010")
    @ParameterizedTest
    @ValueSource(strings = {"   ","1222-32-12", "tonyZe"})
    @NullAndEmptySource
    void shouldThrowCreateInValidBirthDate(String value){
        assertThrows(InvalidDateException.class, ()-> new BirthDate(value));
    }

}