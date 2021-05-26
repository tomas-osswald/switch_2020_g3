package switchtwentytwenty.project.domain.aggregates.category;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class CategoryFactoryTest {

    CategoryFactory categoryFactory = new CategoryFactory();

    @Test
    void createStandardCategory() {
        CategoryJPA standardCategoryJPA = new CategoryJPA("name", 1L, "2", null);
        Category expected = new StandardCategory(new CategoryName("name"),new CategoryID(1L),new ParentCategoryPath("2"));
        Category result = categoryFactory.createCategory(standardCategoryJPA);

        assertNotSame(expected,result);
        assertEquals(expected,result);
    }

    @Test
    void createCustomCategory() {
        CategoryJPA customCategoryJPA = new CategoryJPA("name", 1L, "2", new FamilyIDJPA("@family@id.com"));
        Category expected = new CustomCategory(new CategoryID(1L),new ParentCategoryPath("2"),new CategoryName("name"),new FamilyID("@family@id.com"));
        Category result = categoryFactory.createCategory(customCategoryJPA);

        assertNotSame(expected,result);
        assertEquals(expected,result);
    }
}