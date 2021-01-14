package switch2020.project.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

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

}