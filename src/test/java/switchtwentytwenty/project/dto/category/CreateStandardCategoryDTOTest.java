package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateStandardCategoryDTOTest {

    CreateStandardCategoryDTO createStandardCategoryDTO = new CreateStandardCategoryDTO("desc", 1L, 2L);


    @Test
    void getCategoryDescription() {
        String expected = "desc";
        String result = createStandardCategoryDTO.getCategoryDescription();
        assertEquals(expected, result);
    }

    @Test
    void getCategoryID() {
        Long expected = 1L;
        Long result = createStandardCategoryDTO.getCategoryID();
        assertEquals(expected, result);

    }

    @Test
    void getParentID() {
        Long expected = 2L;
        Long result = createStandardCategoryDTO.getParentID();
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
    void setCategoryID() {
        createStandardCategoryDTO.setCategoryID(5L);
        Long expected = 5L;
        Long result = createStandardCategoryDTO.getCategoryID();
        assertEquals(expected, result);
    }

    @Test
    void setParentID() {
        createStandardCategoryDTO.setParentID(5L);
        Long expected = 5L;
        Long result = createStandardCategoryDTO.getParentID();
        assertEquals(expected, result);
    }

    @Test
    void noArgsConstructorTest() {
        CreateStandardCategoryDTO noArgsDTO = new CreateStandardCategoryDTO();
        noArgsDTO.setParentID(1L);
        noArgsDTO.setCategoryID(2L);
        noArgsDTO.setCategoryDescription("desc");

        assertNotNull(noArgsDTO);
    }
}