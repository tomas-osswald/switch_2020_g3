package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyWithoutAdministratorDTOTest {

    @Test
    void testHashCodeNotEquals() {
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = new FamilyWithoutAdministratorDTO("Simpsons", 1);

        int notExpected = 0;
        int result = familyWithoutAdministratorDTO.hashCode();
        assertNotEquals(notExpected, result);
    }

    @Test
    void testHashCodeEquals() {
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTOOne = new FamilyWithoutAdministratorDTO("Simpsons", 1);
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTOTwo = new FamilyWithoutAdministratorDTO("Simpsons", 1);

        int resultOne = familyWithoutAdministratorDTOOne.hashCode();
        int resultTwo = familyWithoutAdministratorDTOTwo.hashCode();
        assertEquals(resultOne, resultTwo);
    }

    @Test
    void testHashCodeNotEqualsTwo() {
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTOOne = new FamilyWithoutAdministratorDTO("Simpsons", 1);
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTOTwo = new FamilyWithoutAdministratorDTO("Simpsons", 2);

        int resultOne = familyWithoutAdministratorDTOOne.hashCode();
        int resultTwo = familyWithoutAdministratorDTOTwo.hashCode();
        assertNotEquals(resultOne, resultTwo);
    }
}