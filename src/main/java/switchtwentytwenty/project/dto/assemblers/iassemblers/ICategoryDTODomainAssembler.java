package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

public interface ICategoryDTODomainAssembler {

    public OutputCategoryDTO toDTO(Category category);

    public Category toDomain(InputCategoryDTO inputCategoryDTO);
}
