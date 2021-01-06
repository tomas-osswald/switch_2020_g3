package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationTest {

    @Test
    public void getDesignation() {
        Relation uncle = new Relation("uncle");
        String expectedString = "uncle";
        Relation expected = new Relation(expectedString);
        assertEquals(uncle, expected);
    }

    @Test
    public void getDesignationTestNullRelation() {
        String designation = null;
        Relation nullType = new Relation(designation);
        String expected = "relação por definir";
        String result = nullType.getRelationDesignation();
        expected.equals(result);
    }

    @Test
    public void getDesignationTestEmptyRelation() {
        String designation = "";
        Relation empty = new Relation(designation);
        String expected = "relação por definir";
        String result = empty.getRelationDesignation();
        expected.equals(result);
    }


    }