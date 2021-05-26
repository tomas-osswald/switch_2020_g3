package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDTODomainAssemblerTest {

    CategoryID categoryID = new CategoryID(3L);
    CategoryName categoryName = new CategoryName("category");
    ParentCategoryPath parentCategoryPath = new ParentCategoryPath("parent");
    FamilyID familyID = new FamilyID("@tonyze@hotmail.com");
    Optional<FamilyID> familyIDOptional = Optional.of(familyID);
    Category category = new CustomCategory(categoryID, parentCategoryPath,  categoryName, familyID);
    CategoryDTODomainAssembler categoryDTODomainAssembler = new CategoryDTODomainAssembler();


    @Test
    void toDTOSuccessCase() {     //TODO: Fazer teste
    OutputCategoryDTO expected = new OutputCategoryDTO(categoryName.toString(), categoryID.toString(), parentCategoryPath.toString());
    expected.setFamilyID(familyID.getId());

    OutputCategoryDTO result = categoryDTODomainAssembler.toDTO(category);
    result.setFamilyID(familyID.getId());

    assertEquals(expected, result);

    }
}