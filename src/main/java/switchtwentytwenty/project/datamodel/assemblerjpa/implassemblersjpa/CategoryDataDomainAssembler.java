package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

@Component
public class CategoryDataDomainAssembler implements ICategoryDataDomainAssembler {

    @Override
    public CategoryJPA toData(Category category) {
        return null;
    }

    @Override
    public CategoryIDJPA toData(CategoryID categoryID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FamilyIDJPA toData(FamilyID familyID) {
        String familyIDString = familyID.toString();
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyIDString);
        return familyIDJPA;
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
    public CategoryID createCategoryID(CategoryJPA categoryJPA){
        return new CategoryID(categoryJPA.getCategoryIDJPA());
    }

    public CategoryName createCategoryName(CategoryJPA categoryJPA){
        return new CategoryName(categoryJPA.getCategoryName());
    }

    public CategoryID createParentID(CategoryJPA categoryJPA){
        return new CategoryID(categoryJPA.getParentID());
    }

    public FamilyID createFamilyID(CategoryJPA categoryJPA){
        return new FamilyID(categoryJPA.getFamilyIDJPA().getFamilyID());
    }
}
