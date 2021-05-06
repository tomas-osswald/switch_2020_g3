package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputEmailDTOTest {

    @Test
    @DisplayName("Should return true if the unpackEmail method is working correctly")
    void unpackEmail() {
        OutputEmailDTO outputEmailDTO = new OutputEmailDTO("tonyze@gmail.com");

        String expected = "tonyze@gmail.com";
        String result = outputEmailDTO.unpackEmail();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical OutputEmailDTO objects are compared with the equals method")
    void testEquals() {
        OutputEmailDTO outputEmailDTOOne = new OutputEmailDTO("tonyze@gmail.com");
        OutputEmailDTO outputEmailDTOTwo = new OutputEmailDTO("tonyze@gmail.com");

        assertEquals(outputEmailDTOOne, outputEmailDTOTwo);
        assertNotSame(outputEmailDTOOne, outputEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two different OutputEmailDTO objects are compared with the equals method")
    void testEqualsFalse() {
        OutputEmailDTO outputEmailDTOOne = new OutputEmailDTO("tonyze2@gmail.com");
        OutputEmailDTO outputEmailDTOTwo = new OutputEmailDTO("tonyze@gmail.com");

        assertNotEquals(outputEmailDTOOne, outputEmailDTOTwo);
    }

    @Test
    void testEqualsSameOutputEmailDTO() {
        OutputEmailDTO outputEmailDTOOne = new OutputEmailDTO("tonyze@gmail.com");
        OutputEmailDTO outputEmailDTOTwo = outputEmailDTOOne;

        assertEquals(outputEmailDTOOne, outputEmailDTOTwo);
    }

    @Test
    void testEqualsDifferentObjects() {
        OutputEmailDTO outputEmailDTO = new OutputEmailDTO("tonyze@gmail.com");
        String notOutputEmailDTO = "test string";

        assertNotEquals(outputEmailDTO, notOutputEmailDTO);
    }

    @Test
    void testEqualsDifferentFromNull() {
        OutputEmailDTO outputEmailDTO = new OutputEmailDTO("tonyze@gmail.com");

        assertNotEquals(outputEmailDTO, null);
    }

    @Test
    @DisplayName("Should return true if two identical OutputEmailDTO objects have their hashcodes compared")
    void testHashCode() {
        OutputEmailDTO outputEmailDTOOne = new OutputEmailDTO("tonyze@gmail.com");
        OutputEmailDTO outputEmailDTOTwo = new OutputEmailDTO("tonyze@gmail.com");

        assertNotSame(outputEmailDTOOne,outputEmailDTOTwo);
        assertEquals(outputEmailDTOOne.hashCode(),outputEmailDTOTwo.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different OutputEmailDTO objects have their hashcodes compared")
    void testHashCodeFalse() {
        OutputEmailDTO outputEmailDTOOne = new OutputEmailDTO("AAAAtonyze@gmail.com");
        OutputEmailDTO outputEmailDTOTwo = new OutputEmailDTO("tonyze@gmail.com");

        assertNotEquals(outputEmailDTOOne.hashCode(),outputEmailDTOTwo.hashCode());
    }
}