package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;


class CategoryDataDomainAssemblerTest {

    CategoryDataDomainAssembler categoryDataDomainAssembler = new CategoryDataDomainAssembler();
    CategoryJPA customCategoryJPA = new CategoryJPA("catName", 12L, 11L, new FamilyIDJPA("@famid@famid.com"));
    CategoryJPA standardCategoryJPA = new CategoryJPA("catName", 12L, 11L, null);

    @Test
    void toDomain_StandardCategory() {
        CategoryName name = new CategoryName("catName");
        CategoryID categoryID = new CategoryID(12L);
        CategoryID parentID = new CategoryID(11L);
        Category expected = new StandardCategory(name, categoryID, parentID);
        Category result = categoryDataDomainAssembler.toDomain(standardCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);

    }
}