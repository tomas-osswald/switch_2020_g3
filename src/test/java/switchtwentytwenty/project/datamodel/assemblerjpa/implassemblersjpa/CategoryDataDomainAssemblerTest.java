package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;


class CategoryDataDomainAssemblerTest {

    CategoryDataDomainAssembler categoryDataDomainAssembler = new CategoryDataDomainAssembler();
    CategoryJPA customCategoryJPA = new CategoryJPA("catName", 12L, "11L", new FamilyIDJPA("@famid@famid.com"));


    @Test
    void createCategoryID() {
        CategoryID expected = new CategoryID(12L);
        CategoryID result = categoryDataDomainAssembler.createCategoryID(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createCategoryName() {
        CategoryName expected = new CategoryName("catName");
        CategoryName result = categoryDataDomainAssembler.createCategoryName(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createParentID() {
        ParentCategoryPath expected = new ParentCategoryPath("11L");
        ParentCategoryPath result = categoryDataDomainAssembler.createParentID(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createFamilyID() {
        FamilyID expected = new FamilyID("@famid@famid.com");
        FamilyID result = categoryDataDomainAssembler.createFamilyID(customCategoryJPA).get();

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }
}