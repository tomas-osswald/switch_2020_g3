package switchtwentytwenty.project.ONEdomain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.exceptions.InvalidCCException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CCnumberTest {


    CCnumber ccnumber;

    @DisplayName("Test the creation of a valid CCNumbers")
    @ParameterizedTest
    @ValueSource(strings = {"139861572ZW2","19922617 2 ZZ9","18479323 8 ZV1","11805886 0 ZY4","15566920 6 ZX5"})
    void shouldNotThrowCreateValidCCNumber(String value) {
        assertDoesNotThrow(() -> ccnumber = new CCnumber(value));
    }

    @DisplayName("Test that a blank, null and empty String throw exceptions")
    @ParameterizedTest
    @ValueSource(strings = {"  "})
    @NullAndEmptySource
    void shouldThrowNullEmptyBlankCCNumber(String value) {
        assertThrows(InvalidCCException.class, () -> ccnumber = new CCnumber(value));
    }

}