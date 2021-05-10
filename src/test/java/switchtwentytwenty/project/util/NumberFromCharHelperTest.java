package switchtwentytwenty.project.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import switchtwentytwenty.project.deprecated.NumberFromCharHelper;

import static org.junit.jupiter.api.Assertions.*;

class NumberFromCharHelperTest {

    @ParameterizedTest
    @CsvSource({
            "'A', 10",
            "'B', 11",
            "'C', 12",
            "'D', 13",
            "'E', 14",
            "'F', 15",
            "'G', 16",
            "'H', 17",
            "'I', 18",
            "'J', 19",
            "'K', 20",
            "'L', 21",
            "'M', 22",
            "'N', 23",
            "'O', 24",
            "'P', 25",
            "'Q', 26",
            "'R', 27",
            "'S', 28",
            "'T', 29",
            "'U', 30",
            "'V', 31",
            "'W', 32",
            "'X', 33",
            "'Y', 34",
            "'Z', 35",
    })
    void getNumberFromChar(char chars, int ints) {
        int expected = ints;

        int result = NumberFromCharHelper.getNumberFromChar(chars);

        assertEquals(expected, result);
    }

    @Test
    void getNumberFromCharThrows() {
        char invalidChar = '!';

        assertThrows(Exception.class, () -> NumberFromCharHelper.getNumberFromChar(invalidChar));
    }

    @Test
    void numberFromChar(){
        NumberFromCharHelper helper = new NumberFromCharHelper();
        assertNotNull(helper);
    }
}