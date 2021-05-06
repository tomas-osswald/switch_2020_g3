package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputPersonIDDTOTest {

    @Test
    @DisplayName("Should return true if two identical InputPersonDTO objects are compared with the equals method")
    void testEquals() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze@gmail.com");
        InputPersonIDDTO inputPersonIDDTOTwo = new InputPersonIDDTO("tonyze@gmail.com");

        assertEquals(inputPersonIDDTOOne,inputPersonIDDTOTwo);
        assertNotSame(inputPersonIDDTOOne,inputPersonIDDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTO objects are compared with the equals method")
    void testEqualsFalse() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze2@gmail.com");
        InputPersonIDDTO inputPersonIDDTOTwo = new InputPersonIDDTO("tonyze@gmail.com");

        assertNotEquals(inputPersonIDDTOOne,inputPersonIDDTOTwo);
    }

    @Test
    void testEqualsSameInputPersonIDDTO() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze@gmail.com");
        InputPersonIDDTO inputPersonIDDTOTwo = inputPersonIDDTOOne;

        assertEquals(inputPersonIDDTOOne,inputPersonIDDTOTwo);
    }

    @Test
    void testEqualsDifferentObjects() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze@gmail.com");
        String notInputPersonIDDTO = "tonyze@gmail.com";

        assertNotEquals(inputPersonIDDTOOne,notInputPersonIDDTO);
    }

    @Test
    @DisplayName("Should return true if two identical InputPersonDTO objects have their hashcodes compared")
    void testHashCode() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze@gmail.com");
        InputPersonIDDTO inputPersonIDDTOTwo = new InputPersonIDDTO("tonyze@gmail.com");

        assertEquals(inputPersonIDDTOOne.hashCode(),inputPersonIDDTOTwo.hashCode());
        assertNotSame(inputPersonIDDTOOne,inputPersonIDDTOTwo);

    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTO objects have their hashcodes compared")
    void testHashCode_False() {
        InputPersonIDDTO inputPersonIDDTOOne = new InputPersonIDDTO("tonyze2@gmail.com");
        InputPersonIDDTO inputPersonIDDTOTwo = new InputPersonIDDTO("tonyze@gmail.com");

        assertNotEquals(inputPersonIDDTOOne.hashCode(),inputPersonIDDTOTwo.hashCode());
    }

    @Test
    @DisplayName("Should return true if correctly unpacked the stored String")
    void unpackUserID() {
        InputPersonIDDTO inputPersonIDDTO = new InputPersonIDDTO("tonyze@gmail.com");

        String expected = "tonyze@gmail.com";
        String result = inputPersonIDDTO.unpackUserID();

        assertEquals(expected, result);
    }
}