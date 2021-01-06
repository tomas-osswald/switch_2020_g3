package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {

    @Test
    public void createFamilyMember() {
        String name = "José";
        String relation = "filho";
        Relation son = new Relation(relation);
        FamilyMember José = new FamilyMember("José", son, 123);
        String expected = "filho";
        String result = José.getRelation();
        assertTrue(expected.equals(result));
        assertTrue(name.equals(José.getName()));
    }

    // Falta ainda testar o throw para o constructor de FamilyMember.
}