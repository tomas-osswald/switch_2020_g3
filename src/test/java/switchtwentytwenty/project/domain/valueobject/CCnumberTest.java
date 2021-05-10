package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.exceptions.InvalidCCException;

import static org.junit.jupiter.api.Assertions.*;

class CCnumberTest {


    CCnumber ccNumber;

    @DisplayName("Test the creation of a valid CCNumbers")
    @ParameterizedTest
    @ValueSource(strings = {"139861572ZW2","19922617 2 ZZ9","18479323 8 ZV1","11805886 0 ZY4","15566920 6 ZX5"})
    void shouldNotThrowCreateValidCCNumber(String value) {
        assertDoesNotThrow(() -> ccNumber = new CCnumber(value));
    }

    @DisplayName("Test that a blank, null and empty String throw exceptions")
    @ParameterizedTest
    @ValueSource(strings = {"  "})
    @NullAndEmptySource
    void shouldThrowNullEmptyBlankCCNumber(String value) {
        assertThrows(InvalidCCException.class, () -> ccNumber = new CCnumber(value));
    }

    @Test
    void equalsTestEqualCCNumber(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        CCnumber ccNumberTwo = new CCnumber("139861572ZW2");

        assertEquals(ccNumberOne,ccNumberTwo);
        assertNotSame(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestSameCCNumber(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        CCnumber ccNumberTwo = ccNumberOne;

        assertEquals(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestDifferentCCNumber(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        CCnumber ccNumberTwo = new CCnumber("19922617 2 ZZ9");

        assertNotEquals(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestDifferentObjects(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        String notACCNumber = "19922617 2 ZZ9";

        assertNotEquals(ccNumberOne,notACCNumber);
    }

    @Test
    void hashCodeTestEqualHashCode(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        CCnumber ccNumberTwo = new CCnumber("139861572ZW2");

        assertEquals(ccNumberOne.hashCode(),ccNumberTwo.hashCode());
        assertNotSame(ccNumberOne,ccNumberTwo);
    }

    @Test
    void hashCodeTestDifferentHashCode(){
        CCnumber ccNumberOne = new CCnumber("139861572ZW2");
        CCnumber ccNumberTwo = new CCnumber("19922617 2 ZZ9");

        assertNotEquals(ccNumberOne.hashCode(),ccNumberTwo.hashCode());
    }



}