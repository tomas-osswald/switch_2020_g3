package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.output.CategoryTreeDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    Application app = new Application();
    CategoryService categoryService = app.getCategoryService();
    FamilyService familyService = app.getFamilyService();

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

    @Test
    void addStandardCategory_CategoryAlreadyInList() {
        //Arrange
        String categoryName = "Services";
        int parentID = 0;
        //Act
        categoryService.addStandardCategory(categoryName, parentID);
        boolean result = categoryService.addStandardCategory(categoryName, parentID);
        //Assert
        assertFalse(result);
    }

    @Test
    void getCategories() {
        //Arrange
        List<StandardCategory> expectedList = new ArrayList<>();
        StandardCategory categoryOther = new StandardCategory("other", null, 0);
        StandardCategory categoryOne = new StandardCategory("Home", null, 1);
        StandardCategory categoryTwo = new StandardCategory("Education", null, 2);
        StandardCategory categoryThree = new StandardCategory("Food", categoryOne, 3);
        expectedList.add(categoryOther);
        expectedList.add(categoryOne);
        expectedList.add(categoryTwo);
        expectedList.add(categoryThree);
        categoryService.addStandardCategory("Home", 0);
        categoryService.addStandardCategory("Education", 0);
        categoryService.addStandardCategory("Food", 1);
        //Act
        List<StandardCategory> resultList = categoryService.getCategories();
        //Asserts
        assertEquals(expectedList.size(), resultList.size());
        assertEquals(expectedList, resultList);
    }

    @Test
    void getStandardCategoryTree() {
        StandardCategory categoryOne = new StandardCategory("Home", null, 1);

        CategoryTreeDTO result = categoryService.getStandardCategoryTree();

        assertNotNull(result);
    }


    @Test
    void addCategoryToFamilyTreeAssertTrueStandardParent() {
        String categoryName = "Habitação";
        int parentID = 0;
        categoryService.addStandardCategory(categoryName, parentID);
        Family family = new Family("testFamily", 1);
        assertTrue(categoryService.addCategoryToFamilyTree(family, "test", 1));
    }

    @Test
    void addCategoryToFamilyTreeAssertTrueCustomParent() {
        String categoryName = "Habitação";
        int parentID = 0;
        categoryService.addStandardCategory(categoryName, parentID);
        Family family = new Family("testFamily", 1);
        categoryService.addCategoryToFamilyTree(family, "test", 1);
        assertTrue(categoryService.addCategoryToFamilyTree(family, "test2", -1));
    }

    @Test
    void addCategoryToFamilyTreeAssertTrueNoParent() {
        Family family = new Family("testFamily", 1);
        assertTrue(categoryService.addCategoryToFamilyTree(family, "test2", 0));
    }

    @Test
    void addCategoryToFamilyTreeCheckCategoryIDs() {
        Family family = new Family("testFamily", 1);
        familyService.addFamily(family);
        family.addCategory(new CustomCategory("test",0));
        categoryService.addCategoryToFamilyTree(family, "test1", 0);
        categoryService.addCategoryToFamilyTree(family, "test2", 0);
        categoryService.addCategoryToFamilyTree(family, "test3", 0);
        categoryService.addCategoryToFamilyTree(family, "test4", 0);
        categoryService.addCategoryToFamilyTree(family, "test5", 0);
        CategoryTreeDTO dto = categoryService.getCategoryTree(1, familyService);
        List<CustomCategory> catList = dto.getCustomCategories();
        int id = 0;
        for (CustomCategory cat : catList) {

            assertEquals(id, cat.getCategoryID());
            id--;
        }
    }


}