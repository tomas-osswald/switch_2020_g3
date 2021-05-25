package switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa;

import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

public interface ICategoryDataDomainAssembler extends AssemblerDataDomain<CategoryJPA, Category>{

    FamilyIDJPA toData(FamilyID familyID);
}
