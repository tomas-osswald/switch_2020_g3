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
}