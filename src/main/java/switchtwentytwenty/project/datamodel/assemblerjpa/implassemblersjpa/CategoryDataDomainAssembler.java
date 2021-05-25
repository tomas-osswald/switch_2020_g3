package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;

@Component
public class CategoryDataDomainAssembler implements ICategoryDataDomainAssembler {

    @Override
    public CategoryJPA toData(Category category) {
        return null;
    }


    public CategoryID createCategoryID(CategoryJPA categoryJPA) {
        return new CategoryID(categoryJPA.getCategoryIDJPA());
    }

    public CategoryName createCategoryName(CategoryJPA categoryJPA) {
        return new CategoryName(categoryJPA.getCategoryName());
    }

    public ParentCategoryPath createParentID(CategoryJPA categoryJPA) {
        return new ParentCategoryPath(categoryJPA.getParentID());
    }

    public FamilyID createFamilyID(CategoryJPA categoryJPA) {
        return new FamilyID(categoryJPA.getFamilyIDJPA().getFamilyID());
    }
}
