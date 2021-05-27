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

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryDTODomainAssemblerTest {

    CategoryName name = new CategoryName("Casa");
    CategoryID id = new CategoryID(20030L);
    ParentCategoryPath parentID = new ParentCategoryPath("/external/20040");
    FamilyID familyID = new FamilyID("@admin@gmail.com");

    @Test
    void testToDTOStandardCategory() {
        Category category = new StandardCategory(name,id,parentID);
        CategoryDTODomainAssembler assembler = new CategoryDTODomainAssembler();
        OutputCategoryDTO expected = new OutputCategoryDTO("CASA","20030","/external/20040");

        OutputCategoryDTO result = assembler.toDTO(category);

        assertEquals(expected.toString(),result.toString());
        assertEquals(expected.getCategoryID(),result.getCategoryID());
        assertEquals(expected.getParentID(),result.getParentID());
        assertEquals(expected.getCategoryName(),result.getCategoryName());
    }

    @Test
    void testToDTOCustomCategory() {
        Category category = new CustomCategory(id,parentID,name,familyID);
        CategoryDTODomainAssembler assembler = new CategoryDTODomainAssembler();
        OutputCategoryDTO expected = new OutputCategoryDTO("CASA","20030","/external/20040","@admin@gmail.com");

        OutputCategoryDTO result = assembler.toDTO(category);

        assertEquals(expected.toString(),result.toString());
        assertEquals(expected.getCategoryID(),result.getCategoryID());
        assertEquals(expected.getParentID(),result.getParentID());
        assertEquals(expected.getFamilyID(),result.getFamilyID());
        assertEquals(expected.getCategoryName(),result.getCategoryName());
    }

    @Test
    void testCreateCategoryName() {
        CategoryDTODomainAssembler assembler = new CategoryDTODomainAssembler();
        CategoryName expected = new CategoryName("Casa");

        CategoryName result = assembler.createCategoryName("Casa");

        assertEquals(expected,result);
    }

    @Test
    void testCreateParentCategoryPath() {
        CategoryDTODomainAssembler assembler = new CategoryDTODomainAssembler();
        ParentCategoryPath expected = new ParentCategoryPath("/external/20020");

        ParentCategoryPath result = assembler.createParentCategoryPath("/external/20020");

        assertEquals(expected,result);
    }
}