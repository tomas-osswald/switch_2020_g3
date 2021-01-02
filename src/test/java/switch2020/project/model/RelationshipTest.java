package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationshipTest {

    @Test
    public void getDesignation() {
        Relationship uncle = new Relationship("uncle");
        String expectedString = "uncle";
        Relationship expected = new Relationship(expectedString);
        assertEquals(uncle, expected);
    }

    @Test
    public void getDesignationTestNullRelationship() {
        String designation = null;
        Relationship nullType = new Relationship(designation);
        String expected = "relação por definir";
        String result = nullType.getDesignation();
        expected.equals(result);
    }

    @Test
    public void getDesignationTestEmptyRelationship() {
        String designation = "";
        Relationship empty = new Relationship(designation);
        String expected = "relação por definir";
        String result = empty.getDesignation();
        expected.equals(result);
    }


    }