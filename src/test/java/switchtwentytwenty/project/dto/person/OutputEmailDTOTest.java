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
        OutputEmailDTO outputEmailDTO1 = new OutputEmailDTO("tonyze@gmail.com");
        OutputEmailDTO outputEmailDTO2 = new OutputEmailDTO("tonyze@gmail.com");

        assertEquals(outputEmailDTO1, outputEmailDTO2);
        assertNotSame(outputEmailDTO1, outputEmailDTO2);

    }

    @Test
    @DisplayName("Should return false if two different OutputEmailDTO objects are compared with the equals method")
    void testEqualsFalse() {
        OutputEmailDTO outputEmailDTO1 = new OutputEmailDTO("tonyze2@gmail.com");
        OutputEmailDTO outputEmailDTO2 = new OutputEmailDTO("tonyze@gmail.com");

        assertNotEquals(outputEmailDTO1, outputEmailDTO2);
        assertNotSame(outputEmailDTO1, outputEmailDTO2);

    }

    @Test
    @DisplayName("Should return true if two identical OutputEmailDTO objects have their hashcodes compared")
    void testHashCode() {
        OutputEmailDTO outputEmailDTO1 = new OutputEmailDTO("tonyze@gmail.com");
        OutputEmailDTO outputEmailDTO2 = new OutputEmailDTO("tonyze@gmail.com");

        assertNotSame(outputEmailDTO1,outputEmailDTO2);
        assertEquals(outputEmailDTO1.hashCode(),outputEmailDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different OutputEmailDTO objects have their hashcodes compared")
    void testHashCodeFalse() {
        OutputEmailDTO outputEmailDTO1 = new OutputEmailDTO("AAAAtonyze@gmail.com");
        OutputEmailDTO outputEmailDTO2 = new OutputEmailDTO("tonyze@gmail.com");

        assertNotSame(outputEmailDTO1,outputEmailDTO2);
        assertNotEquals(outputEmailDTO1.hashCode(),outputEmailDTO2.hashCode());
    }
}