package switch2020.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        int categoryID = 2;
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

        String result = newStandardCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest2_categoryNameServicos() {
        String categoryName = "Serviços";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest3_categoryNameServicosSpacesBeforeName() {
        String categoryName = "    Serviços";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest4_categoryNameServicosSpacesAfterName() {
        String categoryName = "Serviços    ";
        int categoryID = 2;
        StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory,categoryID);
        String expected = "SERVIÇOS";

        String result = newStandardCategory.getName();

        assertEquals(expected,result);
    }

}