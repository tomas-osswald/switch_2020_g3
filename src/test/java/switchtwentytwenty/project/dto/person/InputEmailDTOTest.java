package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InputEmailDTOTest {

    @Test
    @DisplayName("Test to see if the unpacking method return the saved String in the DTO")
    void unpackEmail() {
        InputEmailDTO inputEmailDTO = new InputEmailDTO("tonyze@gmail.com");
        String expected = "tonyze@gmail.com";
        String result = inputEmailDTO.unpackEmail();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true, if two identical InputEmailDTOs are compared")
    void testEquals() {
        InputEmailDTO inputEmailDTOOne = new InputEmailDTO("tonyze@gmail.com");
        InputEmailDTO inputEmailDTOTwo = new InputEmailDTO("tonyze@gmail.com");

        Assertions.assertNotSame(inputEmailDTOOne, inputEmailDTOTwo);
        Assertions.assertEquals(inputEmailDTOOne, inputEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false, if two different InputEmailDTOs are compared")
    void testEqualsFalse() {
        InputEmailDTO inputEmailDTOOne = new InputEmailDTO("tony2ze@gmail.com");
        InputEmailDTO inputEmailDTOTwo = new InputEmailDTO("tonyze@gmail.com");

        Assertions.assertNotEquals(inputEmailDTOOne, inputEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return true, if it is the same object")
    void testEqualsSameInputEmailDTO() {
        InputEmailDTO inputEmailDTOOne = new InputEmailDTO("tonyze@gmail.com");
        InputEmailDTO inputEmailDTOTwo = inputEmailDTOOne;

        Assertions.assertEquals(inputEmailDTOOne, inputEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false, if two different Object types are compared")
    void testEqualsDifferentObjectTypes() {
        InputEmailDTO inputEmailDTO = new InputEmailDTO("tony2ze@gmail.com");
        String notInputEmailDTO = "tonyze@gmail.com";

        Assertions.assertNotEquals(inputEmailDTO, notInputEmailDTO);
    }

    @Test
    void testEqualsDifferentFromNull() {
        InputEmailDTO inputEmailDTO = new InputEmailDTO("tony2ze@gmail.com");

        assertNotEquals(inputEmailDTO, null);
    }

    @Test
    @DisplayName("Should return true, if two iddentical InputEmailDTOs have their hashcodes compared")
    void testHashCode() {
        InputEmailDTO inputEmailDTO = new InputEmailDTO("tonyze@gmail.com");
        InputEmailDTO inputEmailDTO2 = new InputEmailDTO("tonyze@gmail.com");

        Assertions.assertNotSame(inputEmailDTO, inputEmailDTO2);
        Assertions.assertEquals(inputEmailDTO.hashCode(),inputEmailDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false, if two different InputEmailDTOs have their hashcodes compared")
    void testHashCodeFalse() {
        InputEmailDTO inputEmailDTO = new InputEmailDTO("tonyze2@gmail.com");
        InputEmailDTO inputEmailDTO2 = new InputEmailDTO("tonyze@gmail.com");

        Assertions.assertNotSame(inputEmailDTO, inputEmailDTO2);
        Assertions.assertNotEquals(inputEmailDTO.hashCode(),inputEmailDTO2.hashCode());
    }
}