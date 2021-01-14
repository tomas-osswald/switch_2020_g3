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
    void compareSameRelation() {
        String relationDesignatio = "Mother";
        Relation relation1 = new Relation(relationDesignatio);

        assertSame(relation1, relation1);
        assertEquals(relation1, relation1);
    }
}