package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputCategoryDTOTest {

    @Test
    @DisplayName("Test to check if the getCategoryName method functions correctly")
    void getCategoryName() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", "catID", "parentID");
        String expected = "Name";
        String result = outputCategoryDTO.getCategoryName();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to check if the getCategoryID method functions correctly")
    void getCategoryID() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", "catID", "parentID");
        String expected = "catID";
        String result = outputCategoryDTO.getCategoryID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to check if the getParentID method functions correctly")
    void getParentID() {
        OutputCategoryDTO outputCategoryDTO = new OutputCategoryDTO("Name", "catID", "parentID");
        String expected = "parentID";
        String result = outputCategoryDTO.getParentID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical OutputCategoryDTO objects are compared using the equals method")
    void testEquals() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", "catID", "parentID");
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", "catID", "parentID");

        Assertions.assertEquals(outputCategoryDTO1, outputCategoryDTO2);
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }

    @Test
    @DisplayName("Should return false if two different OutputCategoryDTO objects are compared using the equals method")
    void testEqualsFail() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", "catID", "parentID");
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", "catID", "parentID");

        Assertions.assertNotEquals(outputCategoryDTO1, outputCategoryDTO2);
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }

    @Test
    @DisplayName("Should return true if two identical OutputCategoryDTO objects are compared using their hashcodes")
    void testHashCode() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Name", "catID", "parentID");
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", "catID", "parentID");

        Assertions.assertEquals(outputCategoryDTO1.hashCode(), outputCategoryDTO2.hashCode());
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }

    @Test
    @DisplayName("Should return false if two different OutputCategoryDTO objects are compared using their hashcodes")
    void testHashCodeFail() {
        OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO("Names", "catID", "parentID");
        OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO("Name", "catID", "parentID");

        Assertions.assertNotEquals(outputCategoryDTO1.hashCode(), outputCategoryDTO2.hashCode());
        Assertions.assertNotSame(outputCategoryDTO1, outputCategoryDTO2);
    }
}