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
        //Act
        boolean result = controller.addStandardCategory(categoryName);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_testFailure() {
        //Arrange
        Application FFMapp = new Application();
        AddStandardCategoryController controller = new AddStandardCategoryController(FFMapp);
        String categoryName = "";
        //Act
        boolean result = controller.addStandardCategory(categoryName);
        //Assert
        assertFalse(result);
    }
}