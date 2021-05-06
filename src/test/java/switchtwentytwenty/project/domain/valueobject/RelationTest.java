package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RelationTest {

    EmailAddress personOneID = new EmailAddress("admin@gmail.com");
    EmailAddress personTwoID = new EmailAddress("parent@gmail.com");
    String designation = "Parent";

    @Test
    void constructorTest(){
        Relation relation = new Relation(personOneID,personTwoID,designation);

        assertNotNull(relation);
    }

    @Test
    void equalsTestSameRelation(){
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        Relation relationTwo = relationOne;

        assertEquals(relationOne,relationTwo);
    }

    @Test
    void equalsTestDifferentTypesOfObject(){
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        LocalDate notARelation = LocalDate.of(2001,1,1);

        assertNotEquals(relationOne,notARelation);
    }

    @Test
    void equalsTestEqualRelations(){
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        Relation relationTwo = new Relation(personOneID,personTwoID,designation);

        assertEquals(relationOne,relationTwo);
        assertNotSame(relationOne,relationTwo);
    }

    @Test
    void equalsTestEqualRelationsMembersInDifferentOrder(){
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        Relation relationTwo = new Relation(personTwoID,personOneID,designation);

        assertEquals(relationOne,relationTwo);
        assertNotSame(relationOne,relationTwo);
    }

    @Test
    void equalsTestDifferentRelations(){
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        EmailAddress otherPersonOneID = new EmailAddress("otheremail@hotmail.com");
        Relation relationTwo = new Relation(otherPersonOneID,personTwoID,designation);

        assertNotEquals(relationOne,relationTwo);
    }

    @Test
    void hashCodeTest_sameHashCode() {
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        Relation relationTwo = new Relation(personOneID,personTwoID,designation);

        assertEquals(relationOne.hashCode(),relationTwo.hashCode());
        assertNotSame(relationOne,relationTwo);
    }

    @Test
    void hashCodeTest_differentHashCode() {
        Relation relationOne = new Relation(personOneID,personTwoID,designation);
        EmailAddress otherPersonOneID = new EmailAddress("otheremail@hotmail.com");
        Relation relationTwo = new Relation(otherPersonOneID,personTwoID,designation);

        assertNotEquals(relationOne.hashCode(),relationTwo.hashCode());
    }
}