package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputCategoryDTOTest {

    @Test
    @DisplayName("Test to check if the getCategoryName method functions correctly")
    void getCategoryName() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", 2L, 3L);
        String expected = "Name";
        String result = outputCategoryDTO.getCategoryName();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to check if the getCategoryID method functions correctly")
    void getCategoryID() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", 2L, 3L);
        Long expected = 2L;
        Long result = outputCategoryDTO.getCategoryID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to check if the getParentID method functions correctly")
    void getParentID() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", 2L, 3L);
        Long expected = 3L;
        Long result = outputCategoryDTO.getParentID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical OutputCategoryDTO objects are compared using the equals method")
    void testEquals() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 2L, 3L);

        Assertions.assertEquals(outputCategoryDTO1, outputCategoryDTO2);
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }
    @Test
    @DisplayName("Should return true if it compares two of the same OutputCategoryDTO objects")
    void testEqualsSameObject() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = outputCategoryDTO1;

        Assertions.assertEquals(outputCategoryDTO1, outputCategoryDTO2);
    }
    @Test
    @DisplayName("Should return false if it compares OutputCategoryDTO to an object of another class")
    void testEqualsDifferentClass() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        String otherClass = "This is another class";

        Assertions.assertNotEquals(outputCategoryDTO1, otherClass);
    }
    @Test
    @DisplayName("Should return false if it compares OutputCategoryDTO to a null object")
    void testEqualsWithNullObject() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        String nullString = null;

        Assertions.assertNotEquals(outputCategoryDTO1, nullString);
    }
    @Test
    @DisplayName("Should return false if two different OutputCategoryDTO objects are compared using the equals method")
    void testEqualsFail() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 2L, 3L);

        Assertions.assertNotEquals(outputCategoryDTO1, outputCategoryDTO2);
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }
    @Test
    @DisplayName("Should return false if two OutputCategoryDTO objects are compared while having different categoryName")
    void testEqualsDifferentCategoryName() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("otherName", 2L, 3L);

        Assertions.assertNotEquals(outputCategoryDTO1, outputCategoryDTO2);
    }
    @Test
    @DisplayName("Should return false if two OutputCategoryDTO objects are compared while having different categoryID")
    void testEqualsDifferentCategoryID() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 5L, 3L);

        Assertions.assertNotEquals(outputCategoryDTO1, outputCategoryDTO2);
    }
    @Test
    @DisplayName("Should return false if two OutputCategoryDTO objects are compared while having different parentID")
    void testEqualsDifferentParentID() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 2L, 5L);

        Assertions.assertNotEquals(outputCategoryDTO1, outputCategoryDTO2);
    }

    @Test
    @DisplayName("Should return true if two identical OutputCategoryDTO objects are compared using their hashcodes")
    void testHashCode() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 2L, 3L);

        Assertions.assertEquals(outputCategoryDTO1.hashCode(), outputCategoryDTO2.hashCode());
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }

    @Test
    @DisplayName("Should return false if two different OutputCategoryDTO objects are compared using their hashcodes")
    void testHashCodeFail() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", 2L, 3L);
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", 2L, 3L);

        Assertions.assertNotEquals(outputCategoryDTO1.hashCode(), outputCategoryDTO2.hashCode());
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }


    @Test
    void setCategoryName() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", 2L, 3L);
        outputCategoryDTO1.setCategoryName("NewName");
        String expected = "NewName";
        String result = outputCategoryDTO1.getCategoryName();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void setCategoryID() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", 2L, 3L);
        outputCategoryDTO1.setCategoryID(5L);
        Long expected = 5L;
        Long result = outputCategoryDTO1.getCategoryID();
        Assertions.assertEquals(expected, result);

    }

    @Test
    void setParentID() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", 2L, 3L);
        outputCategoryDTO1.setParentID(5L);
        Long expected = 5L;
        Long result = outputCategoryDTO1.getParentID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void noArgsConstructorTest() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO();
        outputCategoryDTO.setCategoryID(3L);
        Assertions.assertNotNull(outputCategoryDTO);
    }
}