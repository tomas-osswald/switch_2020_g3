package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InputCategoryDTO;
import switchtwentytwenty.project.dto.OutputCategoryDTO;

public interface ICreateStandardCategoryService {

    OutputCategoryDTO createStandardCategory(InputCategoryDTO inputCategoryDTO);
}
