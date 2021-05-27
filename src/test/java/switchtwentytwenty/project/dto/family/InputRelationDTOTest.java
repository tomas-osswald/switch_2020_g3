package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.jupiter.api.Assertions.*;

class InputRelationDTOTest {

    String personIDOne = "personOne";
    String personIDTwo = "personTwo";
    String designation = "relation";
    String familyID = "@tonyze@latinlover.com";
    InputRelationDTO expected = new InputRelationDTO();

    @Test
    void testHashCode() {
        InputRelationDTO result = expected;

        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void getPersonIDOne() {
        expected.setPersonIDOne(personIDOne);

        String result = "personOne";

        assertEquals(expected.getPersonIDOne(), result);
    }

    @Test
    void getPersonIDTwo() {
        expected.setPersonIDTwo(personIDTwo);

        String result = "personTwo";

        assertEquals(expected.getPersonIDTwo(), result);
    }

    @Test
    void getDesignation() {
        expected.setDesignation(designation);

        String result = "relation";

        assertEquals(expected.getDesignation(), result);
    }

    @Test
    void getFamilyID() {
        expected.setFamilyID(familyID);

        String result = "@tonyze@latinlover.com";

        assertEquals(expected.getFamilyID(), result);
            }
}