package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateStandardCategoryDTOTest {

    CreateStandardCategoryDTO createStandardCategoryDTO = new CreateStandardCategoryDTO("desc","2L");


    @Test
    void getCategoryDescription() {
        String expected = "desc";
        String result = createStandardCategoryDTO.getCategoryDescription();
        assertEquals(expected, result);
    }


    @Test
    void getParentID() {
        String expected = "2L";
        String result = createStandardCategoryDTO.getParentCategory();
        assertEquals(expected, result);
    }

    @Test
    void setCategoryDescription() {
        createStandardCategoryDTO.setCategoryDescription("newdesc");
        String expected = "newdesc";
        String result = createStandardCategoryDTO.getCategoryDescription();
        assertEquals(expected, result);
    }

    @Test
    void setParentID() {
        createStandardCategoryDTO.setParentCategory("5L");
        String expected = "5L";
        String result = createStandardCategoryDTO.getParentCategory();
        assertEquals(expected, result);
    }

    @Test
    void noArgsConstructorTest() {
        CreateStandardCategoryDTO noArgsDTO = new CreateStandardCategoryDTO();
        noArgsDTO.setParentCategory("1L");
        noArgsDTO.setCategoryDescription("desc");

        assertNotNull(noArgsDTO);
    }
}