package switch2020.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomCategoryTest {
    StandardCategory parentCategory = new StandardCategory("Others", 10);
    CustomCategory testCategory1 = new CustomCategory("OnlyFans subscriptions", parentCategory, 12);
    CustomCategory testCategory2 = new CustomCategory("Hitomi Tanaka", testCategory1, 13);

    @Test
    void getCategoryName() {
        String expected = "ONLYFANS SUBSCRIPTIONS";
        String result = testCategory1.getCategoryName();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getCategoryID() {
        int expected = 12;
        int result = testCategory1.getCategoryID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getParentIDWhenParentIsStandardCategory() {
        int expected = 10;
        int result = testCategory1.getParentID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getParentIDWhenParentIsCustomCategory() {
        int expected = 12;
        int result = testCategory2.getParentID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void assertThrowsWhenNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CustomCategory invalidCategory = new CustomCategory(null, parentCategory, 20);
        });
    }

    @Test
    void assertThrowsWhenNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CustomCategory invalidCategory = new CustomCategory("", parentCategory, 21);
        });
    }

    @Test
    void assertThrowsWhenNameBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CustomCategory invalidCategory = new CustomCategory("    ", parentCategory, 22);
        });
    }
}