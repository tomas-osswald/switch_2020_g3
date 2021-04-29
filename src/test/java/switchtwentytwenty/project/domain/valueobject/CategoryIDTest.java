package switchtwentytwenty.project.domain.valueobject;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CategoryIDTest {

    Long categoryID = 1L;
    Long differentCategoryID = 2L;

    @Test
    void categoryIDConstructor_Valid() {
        assertDoesNotThrow(() -> new CategoryID(categoryID));
    }

    @Test
    void categoryIDConstructor_NotEquals() {
        CategoryID ID1 = new CategoryID(categoryID);
        CategoryID ID2 = new CategoryID(differentCategoryID);
        assertNotEquals(ID1, ID2);
    }
}