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
    void testEqualsSameObject() {
        InputRelationDTO result = expected;

        assertEquals(expected, result);
        assertEquals(expected, expected);
    }

    @Test
    void testEqualsWithANullObject() {
        InputRelationDTO result = null;

        assertNotEquals(expected, result); }

    @Test
    void testEqualsDifferentObjects() {
        String result = "3";

        assertNotEquals(expected, result);
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

    @Test
    void EqualsWithDifferentMemberOneExpectingNotSame() {
        expected.setPersonIDOne(personIDOne);

        InputRelationDTO result = new InputRelationDTO();

        assertNotEquals(expected, result);
    }

    @Test
    void EqualsWithDifferentMemberTwoExpectingNotSame() {
        expected.setPersonIDOne(personIDOne);
        expected.setPersonIDTwo(personIDTwo);

        InputRelationDTO result = new InputRelationDTO();

        assertNotEquals(expected, result);
    }

    @Test
    void EqualsWithDifferentFamilyIDExpectingNotSame() {
        expected.setPersonIDOne(personIDOne);
        expected.setPersonIDTwo(personIDTwo);
        expected.setFamilyID(familyID);

        InputRelationDTO result = new InputRelationDTO();

        assertNotEquals(expected, result);
    }

    @Test
    void EqualsWithDifferentDesignationExpectingNotSame() {
        expected.setPersonIDOne(personIDOne);
        expected.setPersonIDTwo(personIDTwo);
        expected.setFamilyID(familyID);
        expected.setDesignation(designation);

        InputRelationDTO result = new InputRelationDTO();

        assertNotEquals(expected, result);
    }

}