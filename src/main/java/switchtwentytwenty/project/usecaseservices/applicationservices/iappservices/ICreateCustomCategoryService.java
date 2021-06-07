package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.domain.aggregates.category.CategoryFactory;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.InputCustomCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

public interface ICreateCustomCategoryService {

    OutputCategoryDTO createCustomCategory(InputCustomCategoryDTO inputCustomCategoryDTO);
}
