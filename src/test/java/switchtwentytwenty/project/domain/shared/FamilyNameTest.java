package switchtwentytwenty.project.domain.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyNameTest {


    @Test
    void FamilyNameConstructorTest_Valid(){
        //Arrange
        String familyName = "Ribeiro";
        //Act
        FamilyName newFamilyName = new FamilyName(familyName);
        //Assert
        assertNotNull(newFamilyName);
    }

    @Test
    void FamilyNameConstructorTest_InvalidNull(){
        //Arrange
        String familyName = null;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,()->{
            FamilyName newFamilyName = new FamilyName(familyName);
        });
    }

    @Test
    void FamilyNameConstructorTest_InvalidEmpty(){
        //Arrange
        String familyName = "";
        //Act & Assert
        assertThrows(IllegalArgumentException.class,()->{
            FamilyName newFamilyName = new FamilyName(familyName);
        });
    }

    @Test
    void FamilyNameConstructorTest_InvalidBlank(){
        //Arrange
        String familyName = "  ";
        //Act & Assert
        assertThrows(IllegalArgumentException.class,()->{
            FamilyName newFamilyName = new FamilyName(familyName);
        });
    }

}