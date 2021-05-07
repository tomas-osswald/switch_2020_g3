package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyAndSetAdminDTOTest {

    @Test
    @DisplayName("Should return true if two identical AddFamilyAndSetAdminDTO objetcs are compared with the equals method")
    void testEquals() {
        AddFamilyAndSetAdminDTO dto1 = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
        AddFamilyAndSetAdminDTO dto2 = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        assertEquals(dto1,dto2);
        assertNotSame(dto1,dto2);
    }

    @Test
    @DisplayName("Should return false if two different AddFamilyAndSetAdminDTO objetcs are compared with the equals method")
    void testEqualsFail() {
        AddFamilyAndSetAdminDTO dto1 = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
        AddFamilyAndSetAdminDTO dto2 = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        assertNotEquals(dto1,dto2);
        assertNotSame(dto1,dto2);
    }

    @Test
    void getLocaDate() {
        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        String expectedLocalDate = "12/12/2000";

        String resultLocalDate = dto.getLocalDate();

        assertEquals(expectedLocalDate, resultLocalDate);
    }

    @Test
    void equalsSameObject() {
        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        assertEquals(dto, dto);
    }

    @Test
    void equalsWithNull() {
        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        AddFamilyAndSetAdminDTO nullDTO = null;

        assertNotEquals(dto, nullDTO);
    }

    @Test
    void equalsWithDifferentType() {
        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        String dto2 = "ttony@email.com";

        assertNotEquals(dto, dto2);
    }

    @Test
    void hashTestEquals() {
        AddFamilyAndSetAdminDTO dto1 = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
        AddFamilyAndSetAdminDTO dto2 = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        int hahsDto1 = dto1.hashCode();
        int hashDto2 = dto2.hashCode();

        assertEquals(hahsDto1,hashDto2);
    }

    @Test
    void hashTestnotEquals() {
        AddFamilyAndSetAdminDTO dto1 = new AddFamilyAndSetAdminDTO("ttony@email.com", "Pereira", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
        AddFamilyAndSetAdminDTO dto2 = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        int hahsDto1 = dto1.hashCode();
        int hashDto2 = dto2.hashCode();

        assertNotEquals(hahsDto1,hashDto2);
    }
}