package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.person.FamilyMemberAndRelationsDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testEquals_expectingNotEquals() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO();
        expected.add(dto);

        List<FamilyMemberAndRelationsDTO> result = new ArrayList<>();

        assertNotEquals(expected, result);
    }

    @Test
    void testEqualsWithNullObjectExpectingNotEquals() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO();
        expected.add(dto);

        List<FamilyMemberAndRelationsDTO> result = null;

        assertNotEquals(expected, result);
    }

    @Test
    void testEqualsCompareWithStringExpectingNotEquals() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO();
        expected.add(dto);

        String result = "3";

        assertNotEquals(expected, result);
    }

    @Test
    void testSameHashCodeExpectingEquals() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO();
        expected.add(dto);

        List<FamilyMemberAndRelationsDTO> result = new ArrayList<>();
        result.add(dto);

        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void testDifferentHashCodeExpectingNotEquals() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO("name", "personID", null);
        expected.add(dto);

        List<FamilyMemberAndRelationsDTO> result = new ArrayList<>();


        assertNotEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void testDifferentHashCodeExpectingNotEqualsAgain() {
        List<FamilyMemberAndRelationsDTO> expected = new ArrayList<>();
        FamilyMemberAndRelationsDTO dto = new FamilyMemberAndRelationsDTO("name", "personID", null);
        expected.add(dto);

        List<FamilyMemberAndRelationsDTO> result = new ArrayList<>();
        FamilyMemberAndRelationsDTO dtoNull = new FamilyMemberAndRelationsDTO();
        result.add(dtoNull);


        assertNotEquals(expected.hashCode(), result.hashCode());
    }
}