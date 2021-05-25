package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;


class CategoryDataDomainAssemblerTest {

    CategoryDataDomainAssembler categoryDataDomainAssembler = new CategoryDataDomainAssembler();
    CategoryJPA customCategoryJPA = new CategoryJPA("catName", 12L, 11L, new FamilyIDJPA("@famid@famid.com"));
    CategoryJPA standardCategoryJPA = new CategoryJPA("catName", 12L, 11L, null);


    @Test
    void createCategoryID() {
    }

    @Test
    void createCategoryName() {
    }

    @Test
    void createParentID() {
    }

    @Test
    void createFamilyID() {
    }
}