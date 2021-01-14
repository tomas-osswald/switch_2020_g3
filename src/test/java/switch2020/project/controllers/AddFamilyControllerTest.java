package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Application;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyControllerTest {

    @Test
    void addFamily_testSuccess() {
        //Arrange
        Application FFMapp = new Application();
        AddFamilyController controller = new AddFamilyController(FFMapp);
        String familyName = "Moura";
        //Act
        boolean result = controller.addFamily(familyName);
        //Assert
        assertTrue(result);
    }

    @Test
    void addFamily_testFailure() {
        //Arrange
        Application FFMapp = new Application();
        AddFamilyController controller = new AddFamilyController(FFMapp);
        String familyName = "";
        //Act
        boolean result = controller.addFamily(familyName);
        //Assert
        assertFalse(result);
    }

}