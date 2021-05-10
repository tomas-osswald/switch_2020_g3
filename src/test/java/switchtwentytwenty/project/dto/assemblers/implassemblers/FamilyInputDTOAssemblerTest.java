package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyInputDTOAssemblerTest {

    @Autowired
    FamilyInputDTOAssembler familyAssembler;

    @Autowired
    PersonInputDTOAssembler personAssembler;



    @Test
    void toInputPersonDTO() {

        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        InputPersonDTO expected = new InputPersonDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123");

        InputPersonDTO result = personAssembler.toInputPersonDTO(dto);

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void toInputFamilyDTO() {

        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("ttony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        InputFamilyDTO expected = new InputFamilyDTO("Silva", "12/12/2000");

        InputFamilyDTO result = familyAssembler.toInputFamilyDTO(dto);

        assertEquals(expected, result);
        assertNotNull(result);
    }
}