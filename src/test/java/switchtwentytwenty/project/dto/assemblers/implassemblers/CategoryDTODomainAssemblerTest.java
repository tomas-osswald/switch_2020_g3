package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryDTODomainAssemblerTest {

    @Test
    void toDTO() {
        CategoryDTODomainAssembler categoryDTODomainAssembler = new CategoryDTODomainAssembler();
        Category category = new StandardCategory(new CategoryName("name"));
        assertThrows(UnsupportedOperationException.class,()-> categoryDTODomainAssembler.toDTO(category));
    }
}