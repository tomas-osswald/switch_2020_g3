package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

@Component
public class CategoryDTODomainAssembler implements ICategoryDTODomainAssembler {


    @Override
    public OutputCategoryDTO toDTO(Category category) {
        return null;
    }
}