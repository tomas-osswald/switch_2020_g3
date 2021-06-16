package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class InputRemoveEmailDTOTest {

    String email = "zemanel@gmail.com";
    String personID = "zemanel@hotmail.com";
    String emailTwo = "votorino@gmail.com";
    String personIDTwo = "votorino@hotmail.com";

    @Test
    void getEmail() {
        InputRemoveEmailDTO dto = new InputRemoveEmailDTO(email, personID);
        assertEquals(dto.getEmail(), email);
    }

    @Test
    void getPersonID() {
        InputRemoveEmailDTO dto = new InputRemoveEmailDTO(email, personID);
        assertEquals(dto.getPersonID(), personID);
    }

    @Test
    void setEmail() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setEmail(emailTwo);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setEmail(emailTwo);

        assertEquals(dtoOne, dtoTwo);
        assertNotSame(dtoOne, dtoTwo);
    }

    @Test
    void setPersonID() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personIDTwo);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personIDTwo);

        assertEquals(dtoOne, dtoTwo);
        assertNotSame(dtoOne, dtoTwo);
    }

    @Test
    void testEquals() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personIDTwo);
        dtoOne.setEmail(emailTwo);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personIDTwo);
        dtoTwo.setEmail(emailTwo);

        assertEquals(dtoOne, dtoTwo);
        assertNotSame(dtoOne, dtoTwo);
    }

    @Test
    void testNotEqualsDifferentPersonID() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personID);
        dtoOne.setEmail(email);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personIDTwo);
        dtoTwo.setEmail(email);

        assertNotEquals(dtoOne, dtoTwo);
        assertNotSame(dtoOne, dtoTwo);
    }

    @Test
    void testNotEqualsDifferentEmail() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personID);
        dtoOne.setEmail(email);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personID);
        dtoTwo.setEmail(emailTwo);

        assertNotEquals(dtoOne, dtoTwo);
        assertNotSame(dtoOne, dtoTwo);
    }

    @DisplayName("Different Objects Same hashcode")
    @Test
    void testHashCodeSuccess() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personID);
        dtoOne.setEmail(email);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personID);
        dtoTwo.setEmail(email);

        assertNotSame(dtoOne, dtoTwo);
        assertEquals(dtoOne.hashCode(), dtoTwo.hashCode());
    }

    @DisplayName("Different Objects Different hashcode")
    @Test
    void testHashCodeFail() {
        InputRemoveEmailDTO dtoOne = new InputRemoveEmailDTO();
        dtoOne.setPersonID(personID);
        dtoOne.setEmail(email);
        InputRemoveEmailDTO dtoTwo = new InputRemoveEmailDTO();
        dtoTwo.setPersonID(personID);
        dtoTwo.setEmail(emailTwo);

        assertNotSame(dtoOne, dtoTwo);
        assertNotEquals(dtoOne.hashCode(), dtoTwo.hashCode());
    }
}