package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.exceptions.InvalidNameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @ParameterizedTest
    @Tag("US010")
    @ValueSource(strings = {"  "})
    @NullAndEmptySource
    @DisplayName("Test if a Name Object throws an error if the String is empty, blank or null")
    void shouldThrowIfNameNullBlankEmpty(String value) {
        assertThrows(InvalidNameException.class, () -> new Name(value));
    }
}
