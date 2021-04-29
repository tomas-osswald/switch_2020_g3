package switchtwentytwenty.project.interfaceadapters.controller.IControllers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;

public interface ICategoryRESTController {

    ResponseEntity<Object> createStandardCategory(CreateStandardCategoryDTO createStandardCategoryDTO);

}
