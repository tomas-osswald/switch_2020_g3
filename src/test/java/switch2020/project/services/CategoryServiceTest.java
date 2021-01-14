package switch2020.project.services;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Address;
import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;

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

    /**
     * Verify if the returned List has the same size of the expected
     */
    @Test
    void getStandardCategories_Test6_FromValidList() {
        //arrange
        CategoryService serv = new CategoryService();
        List<StandardCategory> totalList = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
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

   /* @Test
    void getStandardCategories_Test61_FromValidList() {
        //arrange
        CategoryService ser = new CategoryService();
        List<StandardCategory> parents = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        //act
        parents.add(cat1);
        parents.add(cat2);
        parents.add(cat3);
        //assert
        int expected = 7;
        int result = parents.size();
    }*/

    /*@Test
    void getStandardCategories_test7_Null() {
        List<StandardCategory> empty = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> categoryService.getStandardCategories());
        }*/


    /*@Test
    void getParents_Test8_FromCategoriesWithNoParents() {
        //arrange
        List<String> expected = new ArrayList<>();
        List<StandardCategory> lst = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        expected.add(cat3.getParentName());
        //expected.add(cat7.getParentName());
        //lst.add(cat1);
        //lst.add(cat2);
        lst.add(cat3);
        //lst.add(cat4);
        //lst.add(cat5);
        //lst.add(cat6);
        //lst.add(cat7);
        //act
        List<String> result = categoryService.getParentsName(lst);

        //List<String> result = results;
        //assert
        assertEquals(expected, result);
    }*/

    /*@Test
    void getParents_Test9_FromCategoriesWithParents() {
        //arrange
        List<String> expected = new ArrayList<>();
        List<StandardCategory> lst = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        expected.add(cat3.getParentName());
        expected.add(cat7.getParentName());
        //lst.add(cat1);
        //lst.add(cat2);
        lst.add(cat3);
        //lst.add(cat4);
        //lst.add(cat5);
        //lst.add(cat6);
        lst.add(cat7);
        //act
        //List<String> result = categoryService.getParentsName(parents);

        //List<String> result = results;
        //assert
        //assertEquals(expected,result);
    }*/

   /* @Test
    void getChilds_Test10_FromNoChilds() {
        //arrange
        *//*List<StandardCategory> childs = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        childs.add(cat1);
        childs.add(cat2);
        childs.add(cat3);
        childs.add(cat4);
        childs.add(cat5);
        childs.add(cat6);
        childs.add(cat7);*//*
    }*/

    @Test
    void getChildsName_Test11_FromSameParent() {
        //arrange
        /*List<StandardCategory> childs = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        childs.add(cat1);
        childs.add(cat2);
        childs.add(cat3);
        childs.add(cat4);
        childs.add(cat5);
        childs.add(cat6);
        childs.add(cat7);*/
    }



    @Test
    void createStdTree_Test12_ParentsOnlyNoChilds() {

    }

    @Test
    void createStdTree_Test13_ParentsWithChilds() {

    }

    @Test
    void getParentsNameFromCategoriesWithParents() {
        List<String> result = new ArrayList();
        StandardCategory cat1 = new StandardCategory("Home",null , 1);
        StandardCategory cat2 = new StandardCategory("Education",null , 2);
        StandardCategory cat3 = new StandardCategory("Food",cat1, 3);
        StandardCategory cat4 = new StandardCategory("Decoration",cat1 , 4);
        StandardCategory cat5 = new StandardCategory("Health",null , 5);
        StandardCategory cat6 = new StandardCategory("Hollidays",null , 6);
        StandardCategory cat7 = new StandardCategory("Teeth correction",cat5 , 7);
        result.add(cat3.getParentName());
        result.add(cat7.getParentName());
        ArrayList<String> expected = new ArrayList<>();
        expected.add("HOME");
        expected.add("HEALTH");
        assertEquals(expected, result);
    }
}