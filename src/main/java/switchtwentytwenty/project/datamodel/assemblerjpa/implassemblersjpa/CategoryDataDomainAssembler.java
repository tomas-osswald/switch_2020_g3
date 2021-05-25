package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;

public class CategoryDataDomainAssembler implements ICategoryDataDomainAssembler {

    @Override
    public CategoryJPA toData(Category category) {
        return null;
    }
}
