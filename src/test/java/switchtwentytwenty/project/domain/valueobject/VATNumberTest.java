package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.exceptions.InvalidVATException;

import static org.junit.jupiter.api.Assertions.*;

class VATNumberTest {
    final int VALIDVAT = 999999999;
    VATNumber vatNumber;


    @DisplayName("Test the creation of a valid VATNumber")
    @Test
    @Tag("US010")
    void shouldNotThrowCreateValidVAT(){
        assertDoesNotThrow(()->vatNumber = new VATNumber(VALIDVAT));
    }

    @DisplayName("Test that a negative, zero and boundary values throw exceptions")
    @ParameterizedTest
    @Tag("US010")
    @ValueSource(ints = {-1, 0, 99999999,1000000000})
    void shouldThrowBoundaryValuesVATNumber(int value){
        assertThrows(InvalidVATException.class, ()-> vatNumber = new VATNumber(value) );
    }

}