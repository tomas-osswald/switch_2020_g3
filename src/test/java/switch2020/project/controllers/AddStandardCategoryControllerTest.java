package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;

import static org.junit.jupiter.api.Assertions.*;

class AddStandardCategoryControllerTest {

    @Test
    void addStandardCategory_testSuccess() {
        //Arrange
        Application FFMapp = new Application();
        AddStandardCategoryController controller = new AddStandardCategoryController(FFMapp);
        String categoryName = "Habitação";
        int parentID = 0;
        //Act
        boolean result = controller.addStandardCategory(categoryName,parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_testFailure() {
        //Arrange
        Application FFMapp = new Application();
        AddStandardCategoryController controller = new AddStandardCategoryController(FFMapp);
        String categoryName = "";
        int parentID = 0;
        //Act
        boolean result = controller.addStandardCategory(categoryName,parentID);
        //Assert
        assertFalse(result);
    }
}