package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveEmailDTOTest {

    RemoveEmailDTO removeEmailDTO = new RemoveEmailDTO();

    @Test
    void testEquals() {
        String email = "tonyze@latin.com";
        RemoveEmailDTO expected = new RemoveEmailDTO(email);

        RemoveEmailDTO result = new RemoveEmailDTO(email);

        assertEquals(expected, result);

    }

    @Test
    void testEqualsCompareDifferentObjectsExpectingNotEquals() {
        String email = "tonyze@latin.com";

        RemoveEmailDTO result = new RemoveEmailDTO(email);

        assertNotEquals(email, result);

    }

    @Test
    void testEqualsCompareWithNullExpectingNotEquals() {
        RemoveEmailDTO nullDTO = null;

        RemoveEmailDTO result = new RemoveEmailDTO();

        assertNotEquals(nullDTO, result);

    }

    @Test
    void testHashCode() {
        String email = "tonyze@latin.com";
        removeEmailDTO.setEmail(email);
        int expected = removeEmailDTO.hashCode();

        RemoveEmailDTO resultDTO = new RemoveEmailDTO(email);

        int result = resultDTO.hashCode();

        assertEquals(expected, result);
    }


    @Test
    void setEmail() {
        String expected = "tonyze@senhor.com";

        removeEmailDTO.setEmail(expected);

        assertEquals(expected, removeEmailDTO.getEmail());
    }
}