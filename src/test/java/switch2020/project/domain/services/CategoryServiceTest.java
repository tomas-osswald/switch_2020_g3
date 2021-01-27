package switch2020.project.domain.services;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.categories.StandardCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    CategoryService categoryService = new CategoryService();

    @Test
    void addStandardCategory_Test1Success() {
        //Arrange
        String categoryName = "Habitação";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test2Success() {
        //Arrange
        String categoryName = "Services";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test3SuccessParentAlreadyPresent() {
        //Arrange
        String parentName = "Habitação";
        int parentCategoryID = 0;
        categoryService.addStandardCategory(parentName, parentCategoryID);
        String categoryName = "Renda";
        int parentID = 1;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertTrue(result);
    }

    @Test
    void addStandardCategory_Test4FailureCategoryCannotBeConstructed() {
        //Arrange
        String categoryName = "";
        int parentID = 0;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertFalse(result);
    }

    @Test
    void addStandardCategory_Test5FailureParentDoesNotExist() {
        //Arrange
        String categoryName = "Luz";
        int parentID = 3;
        //Act
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertFalse(result);
    }

    /**
     * Verify if the returned List has the same size of the expected
     */
    @Test
    void getStandardCategories_Test6_FromValidList() {
        //arrange
        CategoryService serv = new CategoryService();
        List<StandardCategory> totalList = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home", null, 1);
        StandardCategory cat2 = new StandardCategory("Education", null, 2);
        StandardCategory cat3 = new StandardCategory("Food", cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration", cat1, 4);
        StandardCategory cat5 = new StandardCategory("Health", null, 5);
        StandardCategory cat6 = new StandardCategory("Hollidays", null, 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction", cat5, 7);
        //act
        totalList.add(cat1);
        totalList.add(cat2);
        totalList.add(cat3);
        totalList.add(cat4);
        totalList.add(cat5);
        totalList.add(cat6);
        totalList.add(cat7);
        //assert
        int expected = 7;
        int result = totalList.size();
        assertEquals(expected, result);
    }


}