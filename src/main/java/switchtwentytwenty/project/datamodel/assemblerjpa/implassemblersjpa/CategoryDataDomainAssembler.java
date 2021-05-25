package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

@Component
public class CategoryDataDomainAssembler implements ICategoryDataDomainAssembler {

    @Override
    public CategoryJPA toData(Category category) {
        return null;
    }


    public Category toDomain(CategoryJPA categoryJPA) {
        Category category;
        CategoryID categoryID = new CategoryID(categoryJPA.getCategoryIDJPA());
        CategoryID parentID = new CategoryID(categoryJPA.getParentID());

        CategoryName categoryName = new CategoryName(categoryJPA.getCategoryName());

        if (categoryJPA.getFamilyIDJPA() == null) {
            category = new StandardCategory(categoryName, categoryID, parentID);
        } else {
            FamilyID familyID = new FamilyID(categoryJPA.getFamilyIDJPA().getFamilyID());
            category = new CustomCategory(categoryID, parentID, categoryName, familyID);

        }
        return category;
    }
}
