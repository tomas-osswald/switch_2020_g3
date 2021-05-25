package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

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


}
