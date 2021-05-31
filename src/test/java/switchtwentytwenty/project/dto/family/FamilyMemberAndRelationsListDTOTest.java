package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.person.FamilyMemberAndRelationsDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FamilyMemberAndRelationsListDTOTest {


    @Test
    public void AllArgsConstructor() {
        List<FamilyMemberAndRelationsDTO> familyMemberAndRelationsDTO = new ArrayList<>();
        FamilyMemberAndRelationsListDTO familyMemberAndRelationsListDTO = new FamilyMemberAndRelationsListDTO(familyMemberAndRelationsDTO);

        assertNotNull(familyMemberAndRelationsListDTO);

    }

    @Test
    void getFamilyMemberAndRelationsDTO() {

        List<FamilyMemberAndRelationsDTO> familyMemberAndRelationsDTO = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO();
        familyMemberAndRelationsDTO.add(dto);
        FamilyMemberAndRelationsListDTO familyMemberAndRelationsListDTO = new FamilyMemberAndRelationsListDTO(familyMemberAndRelationsDTO);

        List<FamilyMemberAndRelationsDTO> result = familyMemberAndRelationsListDTO.getFamilyMemberAndRelationsDTO();

        assertNotNull(result);
        assertEquals(familyMemberAndRelationsDTO, result);
    }
}