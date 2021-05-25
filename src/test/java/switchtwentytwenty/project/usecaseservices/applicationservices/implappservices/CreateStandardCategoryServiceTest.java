package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateStandardCategoryServiceTest {

    @Test
    void createStandardCategory() {
        CreateStandardCategoryService service = new CreateStandardCategoryService();
        assertThrows(UnsupportedOperationException.class,()-> service.createStandardCategory(new InputCategoryDTO("x",12L)));
    }

}