package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;

@Service
public class CreateStandardCategoryService implements ICreateStandardCategoryService {
    @Override
    public OutputCategoryDTO createStandardCategory(InputCategoryDTO inputCategoryDTO) {
        return null;
    }
}