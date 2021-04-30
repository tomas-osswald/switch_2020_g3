package switchtwentytwenty.project.interfaceadapters.ImplRepositories;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class CategoryRepositoryTest {

    @Mock
    ICategoryRepositoryJPA categoryRepositoryJPA;
    @Mock
    ICategoryDataDomainAssembler categoryDataDomainAssembler;

    @InjectMocks
    CategoryRepository categoryRepository;

    // Category JPA data
    String categoryDescription = "compras"; //"in english B
    CategoryIDJPA cat = new CategoryIDJPA(12L);
    Long parentID = 0L;
    String familyID = null;
    FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID);

    // Category Data
    CategoryName catName = new CategoryName("BuYs");
    CategoryID selfID = new CategoryID(12L);
    CategoryID parentIDCat = new CategoryID(0L);


    @Test
    @Disabled
    void getByID() {
        CategoryJPA categoryJPA = new CategoryJPA(categoryDescription, cat, parentID, familyIDJPA);
        StandardCategory category = new StandardCategory(catName, selfID, parentIDCat);
        when(categoryRepositoryJPA.findById(any(CategoryIDJPA.class))).thenReturn(Optional.of(categoryJPA));
        when(categoryDataDomainAssembler.toDomain(categoryJPA)).thenReturn(category);

        CategoryID categoryID = new CategoryID(12L);
        Category expected = new StandardCategory(catName,selfID, parentIDCat);

        Category result = categoryRepository.getByID(categoryID);

        assertEquals(expected,result);
        assertNotNull(result);
    }


    @Test
    @Disabled
    void add() {
        StandardCategory category = new StandardCategory(catName, parentIDCat);
        CategoryJPA categoryJPA = new CategoryJPA.Builder(categoryDescription).withParentID(parentID).withFamilyIDJPA(familyIDJPA).build();
        CategoryJPA categoryJPAWithID = new CategoryJPA(categoryDescription, cat, parentID, familyIDJPA);
        when(categoryDataDomainAssembler.toData(category)).thenReturn(categoryJPA);
        when(categoryRepositoryJPA.save(categoryJPA)).thenReturn(categoryJPAWithID);

        Category expected = new StandardCategory(catName, selfID, parentIDCat);
        Category result = categoryRepository.add(category);

        assertEquals(expected,result);
        assertNotNull(result);
    }

}