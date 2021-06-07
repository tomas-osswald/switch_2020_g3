package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.category.ExternalStandardCategoryGroupFourDTO;

public class ExternalCategoryDTODomainAssembler {

    public CategoryID createCategoryID(ExternalStandardCategoryGroupFourDTO externalStandardCategoryGroupFourDTO) {
        return new CategoryID(externalStandardCategoryGroupFourDTO.getId());
    }

    public CategoryName createCategoryName(ExternalStandardCategoryGroupFourDTO externalStandardCategoryGroupFourDTO) {
        return new CategoryName(externalStandardCategoryGroupFourDTO.getName());
    }

    public ParentCategoryPath createParentID(ExternalStandardCategoryGroupFourDTO externalStandardCategoryGroupFourDTO) {
        return new ParentCategoryPath(externalStandardCategoryGroupFourDTO.getParentID());
    }
}
