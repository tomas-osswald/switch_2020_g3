package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputGetProfileDTOTest {

    @Test
    void unpackIDTest() {
        InputGetProfileDTO inputGetProfileDTO = new InputGetProfileDTO("admin@email.com");
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

}