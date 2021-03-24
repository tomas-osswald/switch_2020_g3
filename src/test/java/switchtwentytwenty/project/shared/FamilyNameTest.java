package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyNameTest {

    @Test
    void familyNameConstructorTest_Valid() {
        //Arrange
        String familyName = "Ribeiro";
        //Act
        FamilyName newFamilyName = new FamilyName(familyName);
        //Assert
        assertNotNull(newFamilyName);
    }

    @Test
    void familyNameConstructorTest_InvalidNull() {
        //Arrange
        String familyName = null;
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new FamilyName(familyName)
        );
    }

    @Test
    void familyNameConstructorTest_InvalidEmpty() {
        //Arrange
        String familyName = "";
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new FamilyName(familyName)
        );
    }

    @Test
    void familyNameConstructorTest_InvalidBlank() {
        //Arrange
        String familyName = "  ";
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new FamilyName(familyName)
        );
    }

    @Test
    void equalsTest_equalNotSame() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        FamilyName familyNameTwo = new FamilyName(nameOne);

        assertEquals(familyNameOne, familyNameTwo);
    }

    @Test
    void equalsTest_equalSame() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        FamilyName familyNameTwo = familyNameOne;

        assertEquals(familyNameOne, familyNameTwo);
    }

    @Test
    void equalsTest_notEqual() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        String nameTwo = "Moreira";
        FamilyName familyNameTwo = new FamilyName(nameTwo);

        assertNotEquals(familyNameOne, familyNameTwo);
    }

    @Test
    void equalsTest_notEqualDifferentObject() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        String notFamilyName = "notFamilyName";

        assertNotEquals(familyNameOne, notFamilyName);
    }

    @Test
    void hashCodeTest_sameHashCode() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        FamilyName familyNameTwo = new FamilyName(nameOne);

        assertEquals(familyNameOne.hashCode(), familyNameTwo.hashCode());
    }

    @Test
    void hashCodeTest_differentHashCode() {
        String nameOne = "Ribeiro";
        FamilyName familyNameOne = new FamilyName(nameOne);
        String nameTwo = "Moreira";
        FamilyName familyNameTwo = new FamilyName(nameTwo);

        assertNotEquals(familyNameOne.hashCode(), familyNameTwo.hashCode());
    }
}