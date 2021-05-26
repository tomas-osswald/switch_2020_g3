package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTreeDTOTest {

    @Test
    void testEquals() {
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();
        CategoryTreeDTO categoryTreeDTO1 = new CategoryTreeDTO();
        List<OutputCategoryDTO> dtoList = new ArrayList<>();
        dtoList.add(new OutputCategoryDTO("name", "11", "12", "@fam@id.com"));
        categoryTreeDTO.setCategoryTreeDTO(dtoList);
        categoryTreeDTO1.setCategoryTreeDTO(dtoList);

        assertEquals(categoryTreeDTO, categoryTreeDTO1);


    }

    @Test
    void testEqualsSameObject() {
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();

        List<OutputCategoryDTO> dtoList = new ArrayList<>();
        dtoList.add(new OutputCategoryDTO("name", "11", "12", "@fam@id.com"));
        categoryTreeDTO.setCategoryTreeDTO(dtoList);


        assertEquals(categoryTreeDTO, categoryTreeDTO);


    }

    @Test
    void testEqualsDifferentObject() {
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();

        List<OutputCategoryDTO> dtoList = new ArrayList<>();
        dtoList.add(new OutputCategoryDTO("name", "11", "12", "@fam@id.com"));
        categoryTreeDTO.setCategoryTreeDTO(dtoList);
        String notDto = "string";

        assertNotEquals(categoryTreeDTO, notDto);


    }

    @Test
    void testHashCode() {
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();
        CategoryTreeDTO categoryTreeDTO1 = new CategoryTreeDTO();
        List<OutputCategoryDTO> dtoList = new ArrayList<>();
        dtoList.add(new OutputCategoryDTO("name", "11", "12", "@fam@id.com"));
        categoryTreeDTO.setCategoryTreeDTO(dtoList);
        categoryTreeDTO1.setCategoryTreeDTO(dtoList);

        assertEquals(categoryTreeDTO.hashCode(), categoryTreeDTO1.hashCode());
        assertNotEquals(0, categoryTreeDTO.hashCode());
        assertNotEquals(0, categoryTreeDTO1.hashCode());

    }

    @Test
    void getCategoryTreeDTO() {

        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();

        List<OutputCategoryDTO> dtoList = new ArrayList<>();
        dtoList.add(new OutputCategoryDTO("name", "11", "12", "@fam@id.com"));
        categoryTreeDTO.setCategoryTreeDTO(dtoList);

        List<OutputCategoryDTO> result = categoryTreeDTO.getCategoryTreeDTO();

        assertEquals(dtoList, result);
    }
}