package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputPersonIDDTOTest {

    @Test
    @DisplayName("Should return true if two identical InputPersonDTO objects are compared with the equals method")
    void testEquals() {
        InputPersonIDDTO inputPersonIDDTO1 = new InputPersonIDDTO("tonyze@gmail.com");
        InputPersonIDDTO inputPersonIDDTO2 = new InputPersonIDDTO("tonyze@gmail.com");

        assertEquals(inputPersonIDDTO1,inputPersonIDDTO2);
        assertNotSame(inputPersonIDDTO1,inputPersonIDDTO2);
    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTO objects are compared with the equals method")
    void testEqualsFalse() {
        InputPersonIDDTO inputPersonIDDTO1 = new InputPersonIDDTO("tonyze2@gmail.com");
        InputPersonIDDTO inputPersonIDDTO2 = new InputPersonIDDTO("tonyze@gmail.com");

        assertNotEquals(inputPersonIDDTO1,inputPersonIDDTO2);
        assertNotSame(inputPersonIDDTO1,inputPersonIDDTO2);
    }

    @Test
    @DisplayName("Should return true if two identical InputPersonDTO objects have their hashcodes compared")
    void testHashCode() {
        InputPersonIDDTO inputPersonIDDTO1 = new InputPersonIDDTO("tonyze@gmail.com");
        InputPersonIDDTO inputPersonIDDTO2 = new InputPersonIDDTO("tonyze@gmail.com");

        assertEquals(inputPersonIDDTO1.hashCode(),inputPersonIDDTO2.hashCode());
        assertNotSame(inputPersonIDDTO1,inputPersonIDDTO2);

    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTO objects have their hashcodes compared")
    void testHashCode_False() {
        InputPersonIDDTO inputPersonIDDTO1 = new InputPersonIDDTO("tonyze2@gmail.com");
        InputPersonIDDTO inputPersonIDDTO2 = new InputPersonIDDTO("tonyze@gmail.com");

        assertNotEquals(inputPersonIDDTO1.hashCode(),inputPersonIDDTO2.hashCode());
        assertNotSame(inputPersonIDDTO1,inputPersonIDDTO2);

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