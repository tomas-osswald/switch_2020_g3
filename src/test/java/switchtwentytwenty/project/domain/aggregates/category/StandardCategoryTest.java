package switchtwentytwenty.project.domain.aggregates.category;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

import static org.junit.jupiter.api.Assertions.*;

class StandardCategoryTest {

    @Test
    void id() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);

        CategoryID expected = new CategoryID(1L);
        CategoryID result = standardCategory.id();

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void hasID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);

        CategoryID expected = new CategoryID(1L);
        CategoryID notExpected = new CategoryID(5L);

        assertTrue(standardCategory.hasID(expected));
        assertFalse(standardCategory.hasID(notExpected));

    }

    @Test
    void testEqualsSuccess() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(categoryName, categoryID, parentID);

        assertNotSame(standardCategory, standardCategory2);
        assertEquals(standardCategory, standardCategory2);
    }

    @Test
    void testEqualsSucessSelfCompare() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(categoryName, categoryID, parentID);

        assertNotSame(standardCategory, standardCategory2);
        assertEquals(standardCategory, standardCategory);
    }

    @Test
    void testEqualsFailCompareWithNull() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = null;

        assertNotSame(standardCategory, standardCategory2);
        assertFalse(standardCategory.equals(standardCategory2));
    }

    @Test
    void testEqualsSucessFailNotSameClass() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        String notACategory = "string";

        assertFalse(standardCategory.equals(notACategory));
    }

    @Test
    void testEqualsFalseCategoryName() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(new CategoryName("newname"), categoryID, parentID);

        assertNotSame(standardCategory, standardCategory2);
        assertNotEquals(standardCategory, standardCategory2);
    }

    @Test
    void testEqualsFalseCategoryID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(categoryName, new CategoryID(7L), parentID);

        assertNotSame(standardCategory, standardCategory2);
        assertNotEquals(standardCategory, standardCategory2);
    }

    @Test
    void testEqualsFalseParentID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(categoryName, categoryID, new CategoryID(7L));

        assertNotSame(standardCategory, standardCategory2);
        assertNotEquals(standardCategory, standardCategory2);
    }


    @Test
    void testHashCode() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, categoryID, parentID);
        StandardCategory standardCategory2 = new StandardCategory(categoryName, categoryID, parentID);

        assertEquals(standardCategory.hashCode(), standardCategory2.hashCode());
        assertNotEquals(0, standardCategory.hashCode());
    }

    @Test
    void getCategoryName() {

        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName);

        CategoryName expected = new CategoryName("name");
        CategoryName result = standardCategory.getCategoryName();
        assertEquals(expected, result);
    }

    @Test
    void getParentID() {

        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory(categoryName, parentID);

        CategoryID expected = new CategoryID(2L);
        CategoryID result = standardCategory.getParentID();
        assertEquals(expected, result);
    }

    @Test
    void setCategoryName() {
        CategoryName categoryName = new CategoryName("name");
        StandardCategory standardCategory = new StandardCategory();
        standardCategory.setCategoryName(categoryName);

        CategoryName expected = new CategoryName("name");
        CategoryName result = standardCategory.getCategoryName();
        assertEquals(expected, result);
    }

    @Test
    void setCategoryID() {
        CategoryID categoryID = new CategoryID(1L);
        StandardCategory standardCategory = new StandardCategory();
        standardCategory.setCategoryID(categoryID);

        CategoryID expected = new CategoryID(1L);
        CategoryID result = standardCategory.id();
    }

    @Test
    void setParentID() {
        CategoryID parentID = new CategoryID(1L);
        StandardCategory standardCategory = new StandardCategory();
        standardCategory.setParentID(parentID);

        CategoryID expected = new CategoryID(1L);
        CategoryID result = standardCategory.getParentID();
    }

    @Test
    void testEquals() {
    }
}