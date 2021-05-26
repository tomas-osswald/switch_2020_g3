package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

public interface ICategoryDTODomainAssembler {

    OutputCategoryDTO toDTO(Category category);

    InputCategoryDTO toInputCategoryDTO(CreateStandardCategoryDTO createStandardCategoryDTO);

    CategoryName createCategoryName(String categoryName);

    ParentCategoryPath createParentCategoryPath(String parentCategory);

}