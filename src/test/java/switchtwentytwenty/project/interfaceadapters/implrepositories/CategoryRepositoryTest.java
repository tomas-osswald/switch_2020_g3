package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
class CategoryRepositoryTest {

    @Mock
    ICategoryRepositoryJPA categoryRepositoryJPA;
    @Mock
    ICategoryDataDomainAssembler categoryDataDomainAssembler;

    @InjectMocks
    CategoryRepository categoryRepository;

    @Captor
    ArgumentCaptor<CategoryIDJPA> captor;

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


   /* @Test
    @Disabled
    void getByID() {
        CategoryJPA categoryJPA = new CategoryJPA(categoryDescription, cat, parentID, familyIDJPA);
        StandardCategory category = new StandardCategory(catName, selfID, parentIDCat);
        when(categoryRepositoryJPA.findById(any(CategoryIDJPA.class))).thenReturn(Optional.of(categoryJPA));

        CategoryID categoryID = new CategoryID(12L);
        Category expected = new StandardCategory(catName, selfID, parentIDCat);

        Category result = categoryRepository.getByID(categoryID);

        assertEquals(expected, result);
        assertNotNull(result);
    }*/


    /*@Test
    @Disabled
    void add() {
        StandardCategory category = new StandardCategory(catName, parentIDCat);
        CategoryJPA categoryJPA = new CategoryJPA.Builder(categoryDescription).withParentID(parentID).withFamilyIDJPA(familyIDJPA).build();
        CategoryJPA categoryJPAWithID = new CategoryJPA(categoryDescription, cat, parentID, familyIDJPA);
        when(categoryDataDomainAssembler.toData(category)).thenReturn(categoryJPA);
        when(categoryRepositoryJPA.save(categoryJPA)).thenReturn(categoryJPAWithID);

        Category expected = new StandardCategory(catName, selfID, parentIDCat);
        Category result = categoryRepository.add(category);

        assertEquals(expected, result);
        assertNotNull(result);
    }*/

    /*@Test
    @Disabled
    void testForCaptorFindByID() {

        CategoryID categoryID = new CategoryID(12L);

        CategoryIDJPA expected = new CategoryIDJPA(12L);

        categoryRepository.getByID(categoryID);

        verify(categoryRepositoryJPA).findById(captor.capture());

        CategoryIDJPA result = captor.getValue();

        assertEquals(expected, result);
    }*/

    @Test
    void testGetByID() {
        CategoryID categoryID = new CategoryID(12L);

        assertThrows(UnsupportedOperationException.class, () -> categoryRepository.getByID(categoryID));
    }

    @Test
    void testAdd() {
        CategoryID categoryID = new CategoryID(12L);
        Category category = new StandardCategory(new CategoryName("house"));
        assertThrows(UnsupportedOperationException.class, () -> categoryRepository.add(category));
    }

    @Test
    void getStandardCategoryList() {
        List<Category> expected = new ArrayList<>();
        Category cat1 = new StandardCategory(new CategoryName("name"),new CategoryID(11L),new CategoryID(12L));
        expected.add(cat1);

        List<CategoryJPA> returnList = new ArrayList<>();
        CategoryJPA cat1Clone = new CategoryJPA("name",11L,12L,null);

        returnList.add(cat1Clone);
        Mockito.when(categoryRepositoryJPA.findAllByFamilyIDJPA(null)).thenReturn(returnList);

        List<Category> result = categoryRepository.getStandardCategoryList();

        assertEquals(expected,result);
    }
}