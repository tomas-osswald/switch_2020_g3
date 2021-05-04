package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

public interface ICreateStandardCategoryService {

    OutputCategoryDTO createStandardCategory(InputCategoryDTO inputCategoryDTO);
}
