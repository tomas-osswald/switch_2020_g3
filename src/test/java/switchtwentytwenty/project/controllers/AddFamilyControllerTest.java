package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.Application;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyControllerTest {

    @Test
    void addFamily_testSuccess() {
        //Arrange
        Application ffmApplication = new Application();
        AddFamilyController controller = new AddFamilyController(ffmApplication);
        String familyName = "Moura";
        //Act
        boolean result = controller.addFamily(familyName);
        //Assert
        assertTrue(result);
    }

    @Test
    void addFamily_testFailure() {
        //Arrange
        Application ffmApplication = new Application();
        AddFamilyController controller = new AddFamilyController(ffmApplication);
        String familyName = "";
        //Act
        boolean result = controller.addFamily(familyName);
        //Assert
        assertFalse(result);
    }

}