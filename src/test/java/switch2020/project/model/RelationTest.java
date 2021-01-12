package switch2020.project.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationTest {


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
}

