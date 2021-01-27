package switch2020.project.domain.model.categories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class StandardCategoryTest {

    StandardCategory parentCategory = new StandardCategory("Root", null, 1);

    @Test
    void categoryConstructorTest1_validNameHabitacao () {
        String categoryName = "Habitação";
        int categoryID = 2;

        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory, categoryID);

        assertNotNull(newStandardCategory);
    }

    @Test
    void categoryConstructorTest2_validNameUtilities () {
        String categoryName = "Utilities";
        int categoryID = 3;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);

        assertNotNull(newStandardCategory);
    }

    @Test
    void categoryConstructorTest3_invalidNullName () {
        String categoryName = null;
        int categoryID = 2;

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        });
    }

    @Test
    void categoryConstructorTest4_invalidEmptyName () {
        String categoryName = "";
        int categoryID = 2;

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        });
    }

    @Test
    void categoryConstructorTest5_invalidBlankName () {
        String categoryName = "    ";
        int categoryID = 2;

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        });
    }

    @Test
    void getNameTest1_categoryNameHabitacao() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "HABITAÇÃO";

        String result = newStandardCategory.getCategoryName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest2_categoryNameServicos() {
        String categoryName = "Serviços";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getCategoryName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest3_categoryNameServicosSpacesBeforeName() {
        String categoryName = "    Serviços";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getCategoryName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest4_categoryNameServicosSpacesAfterName() {
        String categoryName = "Serviços    ";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getCategoryName();

        assertEquals(expected,result);
    }

    @Test
    void isIDOfThisCategoryTest1_numberToTestIsCategoryID() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        int numberToTest = 2;

        boolean result = newStandardCategory.isIDOfThisCategory(numberToTest);

        assertTrue(result);
    }

    @Test
    void isIDOfThisCategoryTest2_numberToTestIsNotCategoryID() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        int numberToTest = 5;

        boolean result = newStandardCategory.isIDOfThisCategory(numberToTest);

        assertFalse(result);
    }

    @Test
    void isDesignationOfThisCategoryTest1_designationIsEqual() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String nameToTest = "Habitação";

        boolean result = newStandardCategory.isDesignationOfThisCategory(nameToTest);

        assertTrue(result);
    }

    @Test
    void isDesignationOfThisCategoryTest2_designationHasDifferentCase() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String nameToTest = "HABITAÇÃO";

        boolean result = newStandardCategory.isDesignationOfThisCategory(nameToTest);

        assertTrue(result);
    }

    @Test
    void isDesignationOfThisCategoryTest3_designationHasSpaceAtEnd() {
        String categoryName = "Habitação  ";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String nameToTest = "Habitação";

        boolean result = newStandardCategory.isDesignationOfThisCategory(nameToTest);

        assertTrue(result);
    }

    @Test
    void isDesignationOfThisCategoryTest4_designationIsDifferent() {
        String categoryName = "Habitação  ";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String nameToTest = "Serviços";

        boolean result = newStandardCategory.isDesignationOfThisCategory(nameToTest);

        assertFalse(result);
    }

    @Test
    void getParentNameTest1_parentCategoryNull() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, null,categoryID);
        String expected = "root";

        String result = newStandardCategory.getParentName();

        assertEquals(result, expected);
    }

    @Test
    void getParentNameTest2_parentCategoryHome() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "ROOT";

        String result = newStandardCategory.getParentName();

        assertEquals(result, expected);
    }

    @Test
    void equalsTest1_sameObject() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);

        assertEquals(newStandardCategory, newStandardCategory);
    }

    @Test
    void equalsTest2_notInstanceOf() {
        String categoryName = "Habitação";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        FamilyService familyService = new FamilyService();

        assertNotEquals(newStandardCategory, familyService);
    }

    @Test
    void equalsTest3_sameName() {
        String categoryNameOne = "Habitação";
        int categoryIDOne = 2;
        StandardCategory newStandardCategoryOne = new StandardCategory(categoryNameOne, parentCategory,categoryIDOne);
        String categoryNameTwo = "Habitação";
        int categoryIDTwo = 3;
        StandardCategory newStandardCategoryTwo = new StandardCategory(categoryNameTwo, parentCategory,categoryIDTwo);

        assertEquals(newStandardCategoryOne, newStandardCategoryTwo);
    }

    @Test
    void equalsTest4_differentName() {
        String categoryNameOne = "Habitação";
        int categoryIDOne = 2;
        StandardCategory newStandardCategoryOne = new StandardCategory(categoryNameOne, parentCategory,categoryIDOne);
        String categoryNameTwo = "Casa";
        int categoryIDTwo = 3;
        StandardCategory newStandardCategoryTwo = new StandardCategory(categoryNameTwo, parentCategory,categoryIDTwo);

        assertNotEquals(newStandardCategoryOne, newStandardCategoryTwo);
    }

}