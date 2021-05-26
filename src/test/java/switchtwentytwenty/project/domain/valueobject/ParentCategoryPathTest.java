package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentCategoryPathTest {

    @Test
    void validateParentCategoryPathTestBlankInput(){
        assertThrows(IllegalArgumentException.class,()->new ParentCategoryPath("  "));
    }

    @Test
    void toStringTest(){
        ParentCategoryPath parentCategoryPath = new ParentCategoryPath("/external/categories/200345");
        String expected = "/external/categories/200345";

        String result = parentCategoryPath.toString();

        assertEquals(expected,result);
    }

}