package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailDTOTest {

    @DisplayName("Verify unpack returns expected String")
    @Test
    void unpackEmail() {
        String expected = "tonyze@latinlover.com";
        String id = "3";
        AddEmailDTO resultDTO = new AddEmailDTO(id, expected);

        String result = resultDTO.unpackEmail();

        assertEquals(expected, result);
    }

    @DisplayName("Verify unpack returns different String")
    @Test
    void unpackEmail_notSame() {
        String email = "tonyze@latinlover.com";
        String id = "3";
        String notExpected = "tonyze@grandesphones.com";
        AddEmailDTO resultDTO = new AddEmailDTO(id, email);

        String result = resultDTO.unpackEmail();

        assertNotEquals(notExpected, result);
        assertNotSame(notExpected, result);
    }


    @DisplayName("Verify unpack returns expected String")
    @Test
    void unpackUserID() {
        String expectedEmail = "tonyze@latinlover.com";
        String expectedId = "3";
        AddEmailDTO resultDTO = new AddEmailDTO(expectedId, expectedEmail);

        String result = resultDTO.unpackUserID();

        assertEquals(expectedId, result);
    }

    @DisplayName("Verify unpack returns expected String")
    @Test
    void unpackUserID_notSame() {
        String expectedEmail = "tonyze@latinlover.com";
        String expectedId = "3";
        AddEmailDTO resultDTO = new AddEmailDTO(expectedId, expectedEmail);
        String notExpected = "-3";

        String result = resultDTO.unpackUserID();

        assertNotEquals(notExpected, result);
        assertNotSame(notExpected, result);
    }


    @Test
    @DisplayName("Should return true, testing the Equals method")
    void testEquals() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");

        assertEquals(addEmailDTOOne, addEmailDTOTwo);
        assertNotSame(addEmailDTOOne, addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false (DTO's are not equal), testing the Equals method")
    void testEqualsDifferentID() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze2@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");

        assertNotEquals(addEmailDTOOne, addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false (DTO's are not equal), testing the Equals method")
    void testEqualsDifferentEmail() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = new AddEmailDTO("tonyze@gmail.com", "tonyzealt2@gmail.com");

        assertNotEquals(addEmailDTOOne, addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return true, testing the Equals method with the Same Object")
    void testEqualsSameAddEmailDTO() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = addEmailDTOOne;

        assertEquals(addEmailDTOOne, addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return true, testing the Equals method with the different Object types")
    void testEqualsDifferentObjects() {
        AddEmailDTO addEmailDTO = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        String notAddEmailDTO = "test string";

        assertNotEquals(addEmailDTO, notAddEmailDTO);
    }

    @Test
    void testEqualsDifferentFromNull() {
        AddEmailDTO addEmailDTO = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        String nullString = null;

        assertNotEquals(addEmailDTO, nullString);
    }

    @Test
    @DisplayName("Should return true, if two Equal DTOs have the same hashcode")
    void testHashCode() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");

        assertNotSame(addEmailDTO1, addEmailDTO2);
        assertEquals(addEmailDTO1.hashCode(), addEmailDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false, if two not Equal DTOs have a different hashcode")
    void testHashCodeFalse() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyz2e@gmail.com", "tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com", "tonyzealt@gmail.com");

        assertNotSame(addEmailDTO1, addEmailDTO2);
        assertNotEquals(addEmailDTO1.hashCode(), addEmailDTO2.hashCode());
    }
}