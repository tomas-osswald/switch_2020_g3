package switch2020.project.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationTest {


    @Test
    void creatingRelation() {
        String relationDesignation = "Mother";

        Relation relation = new Relation(relationDesignation);

        assertNotNull(relation);
        assertNotSame(relationDesignation, relation);
    }

    @Test
    void getRelationDesisgnation() {
        String relationDesignation = "Father";
        Relation relation = new Relation(relationDesignation);

        String expected = "Father";

        String result = relation.getRelationDesignation();

        assertEquals(result, expected);
    }

    @Test
    public void getDesignation() {
        Relation expected = new Relation("uncle");
        String expectedString = "uncle";
        Relation test = new Relation(expectedString);
        String result = test.getRelationDesignation();
        assertEquals(expected.getRelationDesignation(), result);
    }

    @Test
    void instationOfARelationObjectWithInvalidArgumentsNull() {
        String relationDesignation = null;

        assertThrows(Exception.class, () -> new Relation(relationDesignation));
    }

    @Test
    void instationOfARelationObjectWithInvalidArgumentsEmpty() {
        String relationDesignation = "";

        assertThrows(Exception.class, () -> new Relation(relationDesignation));
    }
}

