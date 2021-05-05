package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailDTOTest {

    @Test
    @DisplayName("Should return true, testing the Equals method")
    void testEquals() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertEquals(addEmailDTO1,addEmailDTO2);
        assertNotSame(addEmailDTO1,addEmailDTO2);
    }

    @Test
    @DisplayName("Should return false (DTO's are not equal), testing the Equals method")
    void testEqualsFalse() {
        AddEmailDTO addEmailDTO1 = new AddEmailDTO("tonyze2@gmail.com","tonyzealt@gmail.com");
        AddEmailDTO addEmailDTO2 = new AddEmailDTO("tonyze@gmail.com","tonyzealt@gmail.com");

        assertNotEquals(addEmailDTO1,addEmailDTO2);
        assertNotSame(addEmailDTO1,addEmailDTO2);
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