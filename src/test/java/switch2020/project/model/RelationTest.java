package switch2020.project.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
}