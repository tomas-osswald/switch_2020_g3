package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

public interface ICategoryDTODomainAssembler {

    OutputCategoryDTO toDTO(Category category);

}