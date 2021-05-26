package switchtwentytwenty.project.domain.aggregates.category;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.CategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;

import java.util.Optional;


@Component
public class CategoryFactory {
    private final CategoryDataDomainAssembler categoryAssembler = new CategoryDataDomainAssembler();

    public Category createCategory(CategoryJPA registeredCategoryJPA) {

        CategoryID id = categoryAssembler.createCategoryID(registeredCategoryJPA);
        CategoryName name = categoryAssembler.createCategoryName(registeredCategoryJPA);
        ParentCategoryPath parentID = categoryAssembler.createParentID(registeredCategoryJPA);
        Optional<FamilyID> familyID = categoryAssembler.createFamilyID(registeredCategoryJPA);
        Category category;
        if (familyID.isPresent()) {
            category = new CustomCategory(id, parentID, name, familyID.get());
        } else {
            category = new StandardCategory(name, id, parentID);
        }

        return category;
    }
}
