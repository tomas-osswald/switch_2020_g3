package switchtwentytwenty.project.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.person.AddEmailDTO;

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

    }


    //TODO : Finalizar estes testes para cobertura.

    @DisplayName("Verify DTO is equal to another DTO")
    @Test
    void testEquals() {




    }

    @DisplayName("Verify DTO has equal hashcode to another DTO")
    @Test
    void testHashCode() {
    }
}