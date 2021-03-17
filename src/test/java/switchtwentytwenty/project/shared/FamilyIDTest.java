package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FamilyIDTest {

    @Test
    void FamilyIDConstructorTest_Valid(){
        //Arrange
        int familyID = 1;
        //Act
        FamilyID newFamilyID = new FamilyID(familyID);
        //Assert
        assertNotNull(newFamilyID);
    }

    @Test
    void FamilyIDConstructorTest_InvalidZero(){
        //Arrange
        int familyID = 0;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,()-> {
            FamilyID newFamilyID = new FamilyID(familyID);
        });
    }

    @Test
    void FamilyIDConstructorTest_InvalidNegative(){
        //Arrange
        int familyID = -1;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,()-> {
            FamilyID newFamilyID = new FamilyID(familyID);
        });
    }


    @Test
    void EqualsTest_equalNotSame(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = new FamilyID(idOne);

        assertEquals(familyIDOne,familyIDTwo);
    }

    @Test
    void EqualsTest_equalSame(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = familyIDOne;

        assertEquals(familyIDOne,familyIDTwo);
    }

    @Test
    void EqualsTest_notEqual(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        int idTwo = 2;
        FamilyID familyIDTwo = new FamilyID(idTwo);

        assertNotEquals(familyIDOne,familyIDTwo);
    }

    @Test
    void EqualsTest_notEqualDifferentObject(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        String notFamilyID ="notFamilyID";

        assertNotEquals(familyIDOne,notFamilyID);
    }

    @Test
    void HashCodeTest_sameHashCode(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        FamilyID familyIDTwo = new FamilyID(idOne);

        assertEquals(familyIDOne.hashCode(),familyIDTwo.hashCode());
    }

    @Test
    void HashCodeTest_differentHashCode(){
        int idOne = 1;
        FamilyID familyIDOne = new FamilyID(idOne);
        int idTwo = 2;
        FamilyID familyIDTwo = new FamilyID(idTwo);

        assertNotEquals(familyIDOne.hashCode(),familyIDTwo.hashCode());
    }

}