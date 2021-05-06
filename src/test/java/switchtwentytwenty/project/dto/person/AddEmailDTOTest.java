package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailDTOTest {

    @Test
    @DisplayName("Should return true, testing the Equals method")
    void testEquals() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertEquals(addEmailDTOOne,addEmailDTOTwo);
        assertNotSame(addEmailDTOOne,addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return false (DTO's are not equal), testing the Equals method")
    void testEqualsFalse() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze2@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertNotEquals(addEmailDTOOne,addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return true, testing the Equals method with the Same Object")
    void testEqualsSameAddEmailDTO() {
        AddEmailDTO addEmailDTOOne = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTOTwo = addEmailDTOOne;

        assertEquals(addEmailDTOOne,addEmailDTOTwo);
    }

    @Test
    @DisplayName("Should return true, testing the Equals method with the different Object types")
    void testEqualsDifferentObjects() {
        AddEmailDTO addEmailDTO = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");
        String notAddEmailDTO = "test string";

        assertNotEquals(addEmailDTO,notAddEmailDTO);
    }

    @Test
    @DisplayName("Should return true, if two Equal DTOs have the same hashcode")
    void testHashCode() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertNotSame(addEmailDTO1,addEmailDTO2);
        assertEquals(addEmailDTO1.hashCode(),addEmailDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false, if two not Equal DTOs have a different hashcode")
    void testHashCodeFalse() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyz2e@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertNotSame(addEmailDTO1,addEmailDTO2);
        assertNotEquals(addEmailDTO1.hashCode(),addEmailDTO2.hashCode());
    }
}