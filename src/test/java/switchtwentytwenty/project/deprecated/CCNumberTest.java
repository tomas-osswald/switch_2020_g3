package switchtwentytwenty.project.deprecated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.deprecated.CCNumber;
import switchtwentytwenty.project.exceptions.InvalidCCException;

import static org.junit.jupiter.api.Assertions.*;

class CCNumberTest {


    CCNumber ccNumber;

    @DisplayName("Test the creation of a valid CCNumbers")
    @ParameterizedTest
    @ValueSource(strings = {"139861572ZW2","19922617 2 ZZ9","18479323 8 ZV1","11805886 0 ZY4","15566920 6 ZX5"})
    void shouldNotThrowCreateValidCCNumber(String value) {
        ccNumber = new CCNumber(value);
        assertNotNull(ccNumber);
    }

    @DisplayName("Test that a blank, null and empty String throw exceptions")
    @ParameterizedTest
    @ValueSource(strings = {"  "})
    @NullAndEmptySource
    void shouldThrowNullEmptyBlankCCNumber(String value) {
        assertThrows(InvalidCCException.class, () -> ccNumber = new CCNumber(value));
    }

    @DisplayName("Test that an Invalid CCNumber throws an exception")
    @ParameterizedTest
    @ValueSource(strings = {"139861572ZW", "139861572ZW#","139861572ZW3"})
    void shouldThrowInvalidCCNumber(String value) {
        assertThrows(InvalidCCException.class, () -> ccNumber = new CCNumber(value));
    }

    @Test
    void equalsTestEqualCCNumber(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        CCNumber ccNumberTwo = new CCNumber("139861572ZW2");

        assertEquals(ccNumberOne,ccNumberTwo);
        assertNotSame(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestSameCCNumber(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        CCNumber ccNumberTwo = ccNumberOne;

        assertEquals(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestDifferentCCNumber(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        CCNumber ccNumberTwo = new CCNumber("19922617 2 ZZ9");

        assertNotEquals(ccNumberOne,ccNumberTwo);
    }

    @Test
    void equalsTestDifferentObjects(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        String notACCNumber = "19922617 2 ZZ9";

        assertNotEquals(ccNumberOne,notACCNumber);
    }

    @Test
    void hashCodeTestEqualHashCode(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        CCNumber ccNumberTwo = new CCNumber("139861572ZW2");

        assertEquals(ccNumberOne.hashCode(),ccNumberTwo.hashCode());
        assertNotSame(ccNumberOne,ccNumberTwo);
    }

    @Test
    void hashCodeTestDifferentHashCode(){
        CCNumber ccNumberOne = new CCNumber("139861572ZW2");
        CCNumber ccNumberTwo = new CCNumber("19922617 2 ZZ9");

        assertNotEquals(ccNumberOne.hashCode(),ccNumberTwo.hashCode());
    }



}