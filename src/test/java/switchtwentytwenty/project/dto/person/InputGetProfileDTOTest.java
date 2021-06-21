package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputGetProfileDTOTest {

    String jwt = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b255emVAbGF0aW5sb3Zlci5jb20iLCJyb2xlIjoiZmFtaWx5QWRtaW5pc3RyYXRvciIsImV4cCI6MTYyNDExOTUxMCwiaWF0IjoxNjI0MTAxNTEwfQ.cLvrGexHcvyJBZyKiVRHMawNRwLt8qqIx52LOn5fQoKjDdJ8xhymUHEA1lLX3CFc1WicTKab8ned8p3KjSHf_g";

    @Test
    void unpackIDTest() {
        InputGetProfileDTO inputGetProfileDTO = new InputGetProfileDTO("admin@email.com",jwt);
        String expected = "admin@email.com";

        String result = inputGetProfileDTO.unpackID();

        assertEquals(expected,result);
    }

    @Test
    void setID() {
        InputGetProfileDTO inputGetProfileDTO = new InputGetProfileDTO();
        inputGetProfileDTO.setId("admin@email.com");
        String expected = "admin@email.com";

        String result = inputGetProfileDTO.unpackID();

        assertEquals(expected,result);
    }

    @Test
    void testEqualsForEqualDTOs() {
        InputGetProfileDTO inputGetProfileDTOOne = new InputGetProfileDTO("admin@gmail.com",jwt);
        InputGetProfileDTO inputGetProfileDTOTwo = new InputGetProfileDTO("admin@gmail.com",jwt);

        assertEquals(inputGetProfileDTOOne,inputGetProfileDTOTwo);
        assertNotSame(inputGetProfileDTOOne,inputGetProfileDTOTwo);
    }

    @Test
    void testEqualsForSameDTO() {
        InputGetProfileDTO inputGetProfileDTOOne = new InputGetProfileDTO("admin@gmail.com",jwt);
        InputGetProfileDTO inputGetProfileDTOTwo = inputGetProfileDTOOne;

        assertEquals(inputGetProfileDTOOne,inputGetProfileDTOTwo);
        assertSame(inputGetProfileDTOOne,inputGetProfileDTOTwo);
    }

    @Test
    void testEqualsForDifferentDTOs() {
        InputGetProfileDTO inputGetProfileDTOOne = new InputGetProfileDTO("admin@gmail.com",jwt);
        InputGetProfileDTO inputGetProfileDTOTwo = new InputGetProfileDTO("notadmin@gmail.com",jwt);

        assertNotEquals(inputGetProfileDTOOne,inputGetProfileDTOTwo);
    }

    @Test
    void testEqualsForDifferentObjects() {
        InputGetProfileDTO inputGetProfileDTO = new InputGetProfileDTO("admin@gmail.com",jwt);
        String notADTO = "notadmin@gmail.com";

        assertNotEquals(inputGetProfileDTO,notADTO);
    }

    @Test
    void testEqualsForDifferentFromNull() {
        InputGetProfileDTO inputGetProfileDTO = new InputGetProfileDTO("admin@gmail.com",jwt);
        String nullString = null;

        assertNotEquals(inputGetProfileDTO,nullString);
    }

    @Test
    void testHashCodeSameHashCode() {
        InputGetProfileDTO inputGetProfileDTOOne = new InputGetProfileDTO("admin@gmail.com",jwt);
        InputGetProfileDTO inputGetProfileDTOTwo = new InputGetProfileDTO("admin@gmail.com",jwt);

        assertEquals(inputGetProfileDTOOne.hashCode(),inputGetProfileDTOTwo.hashCode());
        assertNotSame(inputGetProfileDTOOne,inputGetProfileDTOTwo);
    }

    @Test
    void testHashCodeDifferentHashCodes() {
        InputGetProfileDTO inputGetProfileDTOOne = new InputGetProfileDTO("admin@gmail.com",jwt);
        InputGetProfileDTO inputGetProfileDTOTwo = new InputGetProfileDTO("notadmin@gmail.com",jwt);

        assertNotEquals(inputGetProfileDTOOne.hashCode(),inputGetProfileDTOTwo.hashCode());
    }

}