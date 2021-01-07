package switch2020.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void categoryConstructorTest1_validNameHabitacao () {
        String categoryName = "Habitação";
        Category newCategory = new Category(categoryName);

        assertNotNull(newCategory);
    }

    @Test
    void categoryConstructorTest2_validNameUtilities () {
        String categoryName = "Utilities";
        Category newCategory = new Category(categoryName);

        assertNotNull(newCategory);
    }

    @Test
    void categoryConstructorTest3_invalidNullName () {
        String categoryName = null;

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            Category newCategory = new Category(categoryName);
        });
    }

    @Test
    void categoryConstructorTest4_invalidEmptyName () {
        String categoryName = "";

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            Category newCategory = new Category(categoryName);
        });
    }

    @Test
    void getNameTest1_categoryNameHabitacao() {
        String categoryName = "Habitação";
        Category newCategory = new Category(categoryName);
        String expected = "HABITAÇÃO";

        String result = newCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest2_categoryNameServicos() {
        String categoryName = "Serviços";
        Category newCategory = new Category(categoryName);
        String expected = "SERVIÇOS";

        String result = newCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest3_categoryNameServicosSpacesBeforeName() {
        String categoryName = "    Serviços";
        Category newCategory = new Category(categoryName);
        String expected = "SERVIÇOS";

        String result = newCategory.getName();

        assertEquals(expected,result);
    }

    @Test
    void getNameTest4_categoryNameServicosSpacesAfterName() {
        String categoryName = "Serviços    ";
        Category newCategory = new Category(categoryName);
        String expected = "SERVIÇOS";

        String result = newCategory.getName();

        assertEquals(expected,result);
    }


    @Test
    void isStandardTest1_true() {
        String categoryName = "Serviços";
        Category newCategory = new Category(categoryName);

        boolean result = newCategory.isStandardCategory();

        assertTrue(result);
    }

}