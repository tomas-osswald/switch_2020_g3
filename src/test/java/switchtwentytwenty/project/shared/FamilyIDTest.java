package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.shared.FamilyID;

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

}