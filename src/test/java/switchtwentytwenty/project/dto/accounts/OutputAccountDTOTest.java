package switchtwentytwenty.project.dto.accounts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutputAccountDTOTest {
    String ACCOUNTID = "3";
    String PERSONOWNERID = "tonyZe@latinlover.com";
    String DESIGNATION = "Noitadas";

    @Test
    void getAccountIDTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        String expected = "3";

        String result = outputAccountDTOOne.getAccountID();

        assertEquals(expected, result);
    }
    @Test
    void getOwnerIDTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        String expected = "tonyZe@latinlover.com";

        String result = outputAccountDTOOne.getOwnerID();

        assertEquals(expected, result);
    }
    @Test
    void getDesignationTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        String expected = "Noitadas";

        String result = outputAccountDTOOne.getDesignation();

        assertEquals(expected, result);
    }
    @Test
    void setAccountIDTest(){
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO();
        outputAccountDTOOne.setAccountID(ACCOUNTID);

        String expected = "3";

        String result = outputAccountDTOOne.getAccountID();

        assertEquals(expected, result);
    }
    @Test
    void setOwnerIDTest(){
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO();
        outputAccountDTOOne.setOwnerID(PERSONOWNERID);

        String expected = "tonyZe@latinlover.com";

        String result = outputAccountDTOOne.getOwnerID();

        assertEquals(expected, result);
    }
    @Test
    void setDesignationTest(){
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO();
        outputAccountDTOOne.setDesignation(DESIGNATION);

        String expected = "Noitadas";

        String result = outputAccountDTOOne.getDesignation();

        assertEquals(expected, result);
    }
    @Test
    void equalsTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);
        OutputAccountDTO outputAccountDTOTwo = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        assertEquals(outputAccountDTOOne, outputAccountDTOTwo);
        assertNotSame(outputAccountDTOOne, outputAccountDTOTwo);
    }
    @Test
    void equalsTestIsDifferentObject() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);
        OutputAccountDTO outputAccountDTOTwo = new OutputAccountDTO();

        assertNotEquals(outputAccountDTOOne, outputAccountDTOTwo);
    }
    @Test
    void equalsTestIsDifferentClass() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        assertNotEquals(outputAccountDTOOne, ACCOUNTID);
    }
    @Test
    void equalsTestIsDifferent() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);
        OutputAccountDTO outputAccountDTOTwo = outputAccountDTOOne;

        assertSame(outputAccountDTOOne, outputAccountDTOTwo);
    }
    @Test
    void hashCodeIsEqualTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);
        OutputAccountDTO outputAccountDTOTwo = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);

        assertEquals(outputAccountDTOOne.hashCode(), outputAccountDTOTwo.hashCode());
    }
    @Test
    void hashCodeIsDifferentTest() {
        OutputAccountDTO outputAccountDTOOne = new OutputAccountDTO(ACCOUNTID, PERSONOWNERID, DESIGNATION);
        OutputAccountDTO outputAccountDTOTwo = new OutputAccountDTO("5", PERSONOWNERID, DESIGNATION);

        assertNotEquals(outputAccountDTOOne.hashCode(), outputAccountDTOTwo.hashCode());
    }

}