package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;

public interface ICategoryRESTController {

    ResponseEntity<Object> createStandardCategory(CreateStandardCategoryDTO createStandardCategoryDTO);

}
