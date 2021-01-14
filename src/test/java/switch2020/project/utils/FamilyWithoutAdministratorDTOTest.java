package switch2020.project.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyWithoutAdministratorDTOTest {

    @Test
    void compareSameFamilyWithoutAdministratorDTO() {
        String name = "Simpsons";
        int id = 1;

        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = new FamilyWithoutAdministratorDTO(name, id);

        assertSame(familyWithoutAdministratorDTO, familyWithoutAdministratorDTO);
        assertEquals(familyWithoutAdministratorDTO, familyWithoutAdministratorDTO);
    }

    @Test
    void compareFamilyWithoutAdministratorDTOAnotherInstanceOfSameClasseWithSameAttributes() {
        String name1 = "Simpsons";
        int id1 = 1;
        String name2 = "Simpsons";
        int id2 = 1;

        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO1 = new FamilyWithoutAdministratorDTO(name1, id1);
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO2 = new FamilyWithoutAdministratorDTO(name2, id2);

        assertNotSame(familyWithoutAdministratorDTO1, familyWithoutAdministratorDTO2);
        assertEquals(familyWithoutAdministratorDTO1, familyWithoutAdministratorDTO2);
    }

    @Test
    void compareFamilyWithoutAdministratorDTOAnotherInstanceOfSameClasseWithouSameAttributes() {
        String name1 = "Flanders";
        int id1 = 1;
        String name2 = "Simpsons";
        int id2 = 2;

        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO1 = new FamilyWithoutAdministratorDTO(name1, id1);
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO2 = new FamilyWithoutAdministratorDTO(name2, id2);

        assertNotSame(familyWithoutAdministratorDTO1, familyWithoutAdministratorDTO2);
        assertNotEquals(familyWithoutAdministratorDTO1, familyWithoutAdministratorDTO2);
    }

    @Test
    void compareFamilyWithoutAdministratorDTOAnotherClassInstance() {
        String name = "Simpsons";
        int id = 1;

        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = new FamilyWithoutAdministratorDTO(name, id);

        assertNotEquals(familyWithoutAdministratorDTO, name);
    }
}