package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

@Component
public class CategoryDTODomainAssembler implements ICategoryDTODomainAssembler {


    @Override
    public OutputCategoryDTO toDTO(Category category) {
        throw new UnsupportedOperationException();
    }

    public InputCategoryDTO toInputCategoryDTO(CreateStandardCategoryDTO createStandardCategoryDTO){
        String description = createStandardCategoryDTO.getCategoryDescription();
        Long parentID = createStandardCategoryDTO.getParentID();
        InputCategoryDTO inputCategoryDTO = new InputCategoryDTO(description,parentID);

        return inputCategoryDTO;
    }
}