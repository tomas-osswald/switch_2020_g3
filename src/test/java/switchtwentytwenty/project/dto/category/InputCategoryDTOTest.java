package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputCategoryDTOTest {

    @Test
    @DisplayName("Test to see if the getCategoryName method functions correctly")
    void getCategoryName() {
        InputCategoryDTO inputCategoryDTO = new InputCategoryDTO("House", 1L);
        String expected = "House";
        String result = inputCategoryDTO.getCategoryName();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to see if the getParentID method functions correctly")
    void getParentID() {
        InputCategoryDTO inputCategoryDTO = new InputCategoryDTO("House", 1L);
        Long expected = 1L;
        Long result = inputCategoryDTO.getParentID();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical InputCategoryDTO objects are compared using the equals method")
    void testEquals() {
        InputCategoryDTO inputCategoryDTO1 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO inputCategoryDTO2 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO nullDTO = null;
        String notDTO = "string";
        assertEquals(inputCategoryDTO1, inputCategoryDTO2);
        assertNotSame(inputCategoryDTO1, inputCategoryDTO2);
        assertTrue(inputCategoryDTO1.equals(inputCategoryDTO1));
        assertFalse(inputCategoryDTO1.equals(nullDTO));
        assertFalse(inputCategoryDTO1.equals(notDTO));

    }

    @Test
    @DisplayName("Should return false if two different InputCategoryDTO objects are compared using the equals method")
    void testEqualsFalseDifferentParentID() {
        InputCategoryDTO inputCategoryDTO1 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO inputCategoryDTO2 = new InputCategoryDTO("House", 2L);

        assertNotEquals(inputCategoryDTO1, inputCategoryDTO2);
        assertNotSame(inputCategoryDTO1, inputCategoryDTO2);

    }
    @Test
    @DisplayName("Should return false if two different InputCategoryDTO objects are compared using the equals method")
    void testEqualsFalseDifferentCategoryName() {
        InputCategoryDTO inputCategoryDTO1 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO inputCategoryDTO2 = new InputCategoryDTO("otherHouse", 1L);

        assertNotEquals(inputCategoryDTO1, inputCategoryDTO2);
        assertNotSame(inputCategoryDTO1, inputCategoryDTO2);

    }

    @Test
    @DisplayName("Should return true if two identical InputCategoryDTO objects are compared using their hash codes")
    void testHashCode() {
        InputCategoryDTO inputCategoryDTO1 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO inputCategoryDTO2 = new InputCategoryDTO("House", 1L);

        assertEquals(inputCategoryDTO1.hashCode(), inputCategoryDTO2.hashCode());
        assertNotSame(inputCategoryDTO1, inputCategoryDTO2);

    }

    @Test
    @DisplayName("Should return false if two different InputCategoryDTO objects are compared using their hash codes")
    void testHashCodeFalse() {
        InputCategoryDTO inputCategoryDTO1 = new InputCategoryDTO("House", 1L);
        InputCategoryDTO inputCategoryDTO2 = new InputCategoryDTO("House", 2L);

        assertNotEquals(inputCategoryDTO1.hashCode(), inputCategoryDTO2.hashCode());
        assertNotSame(inputCategoryDTO1, inputCategoryDTO2);

    }


}