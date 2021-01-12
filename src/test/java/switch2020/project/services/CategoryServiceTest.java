package switch2020.project.services;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    Application app = new Application();
    CategoryService categoryService = new CategoryService();

    @Test
    void addStandardCategory_Test1Success() {
        //Arrange
        String categoryName = "Habitação";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName,  parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test2Success() {
        //Arrange
        String categoryName = "Services";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName,  parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test3SuccessParentAlreadyPresent() {
        //Arrange
        String parentName = "Habitação";
        int parentCategoryID = 0;
        categoryService.addStandardCategory(parentName,  parentCategoryID);
        String categoryName = "Renda";
        int parentID = 1;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName,  parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test4FailureCategoryCannotBeConstructed() {
        //Arrange
        String categoryName = "";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName,  parentID);
        //Assert
        assertFalse(result);
    }

    @Test
    void addStandardCategory_Test5FailureParentDoesNotExist() {
        //Arrange
        String categoryName = "Luz";
        int parentID = 3;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName,  parentID);
        //Assert
        assertFalse(result);
    }


}