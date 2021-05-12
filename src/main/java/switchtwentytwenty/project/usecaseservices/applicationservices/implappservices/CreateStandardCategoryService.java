package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

@Service
@NoArgsConstructor
public class CreateStandardCategoryService implements ICreateStandardCategoryService {

    private CategoryDTODomainAssembler categoryDTODomainAssembler;
    private ICategoryRepository categoryRepository;

    @Override
    public OutputCategoryDTO createStandardCategory(InputCategoryDTO inputCategoryDTO) {
        throw new UnsupportedOperationException();

    }
}