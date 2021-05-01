package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;

import static org.junit.jupiter.api.Assertions.*;

class FamilyIDJPATest {

    String familyID = "1";
    String familyIDTwo = "2";

    @Tag("US010")
    @Test
    void testEquals() {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);

        assertEquals(familyIDJPA, familyIDJPA);
    }

    @Tag("US010")
    @Test
    void testEqualsTwo() {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);
        FamilyIDJPA familyIDJPATwo = new FamilyIDJPA(familyID);

        assertEquals(familyIDJPA, familyIDJPATwo);
    }

    @Tag("US010")
    @Test
    void testToString() {
        String expected = "1";

        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);

        String result = familyIDJPA.toString();

        assertEquals(expected, result);
    }

    @Tag("US010")
    @Test
    void getFamilyID() {
        String expected = "1";

        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);


        String result = familyIDJPA.getFamilyID();

        assertEquals(expected, result);

    }

    @Test
    void setFamilyID() {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);
        String expected = "2";

        familyIDJPA.setFamilyID("2");
        String result = familyIDJPA.getFamilyID();

        assertEquals(expected,result);
    }

    @Test
    void hashCodeEqualFamilies() {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);
        FamilyIDJPA familyIDJPATwo = new FamilyIDJPA(familyID);

        assertEquals(familyIDJPA.hashCode(), familyIDJPATwo.hashCode());
        assertNotSame(familyIDJPA, familyIDJPATwo);
    }

    @Test
    void hashCodeDifferentFamilies() {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);
        FamilyIDJPA familyIDJPATwo = new FamilyIDJPA(familyIDTwo);

        assertNotEquals(familyIDJPA.hashCode(), familyIDJPATwo.hashCode());
    }
}