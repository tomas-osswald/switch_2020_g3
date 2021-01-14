package switch2020.project.domain.utils;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Relation;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberRelationDTOTest {

    FamilyMemberRelationDTO test = new FamilyMemberRelationDTO("josé", "filho");

    @Test
    void getName() {
        String expected = "josé";
        String result = test.getName();
        assertEquals(expected, result);
    }

    @Test
    void getRelationDesignation() {
        String expected = "filho";
        String result = test.getRelationDesignation();
        assertEquals(expected, result);
    }

    @Test
    void compareSameDTO() {
        String relationDesignatio = "Mother";
        String name = "Maria";
        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(name, relationDesignatio);

        assertSame(relation1, relation1);
        assertEquals(relation1, relation1);
    }

    @Test
    void compareDTOWithAnotherClass() {
        String relationDesignatio = "Mother";
        String name = "Maria";
        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(name, relationDesignatio);

        assertNotSame(relation1, relationDesignatio);
        assertNotEquals(relation1, relationDesignatio);
    }

    @Test
    void compareTwoInstancesOfDTOEquals() {
        String relationDesignatio = "Mother";
        String name = "Maria";
        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(name, relationDesignatio);

        String relationDesignatio2 = "Mother";
        String name2 = "Maria";
        FamilyMemberRelationDTO relation2 = new FamilyMemberRelationDTO(name2, relationDesignatio2);

        assertNotSame(relation1, relation2);
        assertEquals(relation1, relation2);
    }

    @Test
    void compareTwoInstancesOfDTO() {
        String relationDesignatio = "Mother";
        String name = "Maria";
        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(name, relationDesignatio);

        String relationDesignatio2 = "Mother";
        String name2 = "Lara";
        FamilyMemberRelationDTO relation2 = new FamilyMemberRelationDTO(name2, relationDesignatio2);

        assertNotSame(relation1, relation2);
        assertNotEquals(relation1, relation2);
    }
}