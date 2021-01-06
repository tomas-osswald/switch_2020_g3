package switch2020.project.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import switch2020.project.model.Relation;

class RelationTest {

    @Test
    void NullRelationDesignationIsGiven() {
        String relationDesignation = null;

        assertThrows(IllegalArgumentException.class, () -> new Relation(relationDesignation));
    }

    @Test
    void EmptyRelationDesignation() {
        String relationDesignatin = "";

        assertThrows(IllegalArgumentException.class, () -> new Relation(relationDesignatin));
    }

    @Test
    void CreatingRelation() {
        String relationDesignation = "Mother";

        Relation relation = new Relation(relationDesignation);

        assertNotNull(relation);
        assertNotSame(relationDesignation, relation);
    }

    @Test
    void GetRelationDesisgnation() {
        String relationDesignation = "Father";

        Relation relation = new Relation(relationDesignation);

        String expected = "Father";

        assertEquals(expected, relation.getRelationDesignation());
    }

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

