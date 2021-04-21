package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FamilyIDTest {

    @Test
    @Tag("US010")
    void familyIDConstructorTest_Valid() {
        //Arrange
        UUID familyID = UUID.randomUUID();
        //Act
        FamilyID newFamilyID = new FamilyID(familyID);
        //Assert
        assertNotNull(newFamilyID);
    }

    @Test
    @Tag("US010")
    void familyIDConstructorTest_InvalidNull() {
        //Arrange
        UUID familyID = null;
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new FamilyID(familyID)
        );
    }

    @Test
    @Tag("US010")
    void equalsTest_equalNotSame() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = new FamilyID(idOne);

        assertNotSame(familyIDOne, familyIDTwo);
        assertEquals(familyIDOne, familyIDTwo);
    }

    @Test
    @Tag("US010")
    void equalsTest_equalSame() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = familyIDOne;

        assertSame(familyIDOne, familyIDTwo);
        assertEquals(familyIDOne, familyIDTwo);
    }

    @Test
    @Tag("US010")
    void equalsTest_notEqual() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        UUID idTwo = UUID.randomUUID();
        FamilyID familyIDTwo = new FamilyID(idTwo);

        assertNotEquals(familyIDOne, familyIDTwo);
    }

    @Test
    @Tag("US010")
    void equalsTest_notEqualDifferentObject() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        String notFamilyID = "notFamilyID";

        assertNotEquals(familyIDOne, notFamilyID);
    }

    @Test
    @Tag("US010")
    void hashCodeTest_sameHashCode() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = new FamilyID(idOne);

        assertEquals(familyIDOne.hashCode(), familyIDTwo.hashCode());
    }

    @Test
    @Tag("US010")
    void hashCodeTest_differentHashCode() {
        UUID idOne = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(idOne);
        UUID idTwo = UUID.randomUUID();
        FamilyID familyIDTwo = new FamilyID(idTwo);

        assertNotEquals(familyIDOne.hashCode(), familyIDTwo.hashCode());
    }

}