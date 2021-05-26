package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomCategoriesServiceTest {

    @Mock
    ICategoryRepository categoryRepository;

    @Mock
    CategoryDTODomainAssembler categoryDTODomainAssembler;

    @InjectMocks
    GetCustomCategoriesService getCustomCategoriesService;

    String stringStandardCategoryName = "Standard Category Name";
    Long stringStandardCategoryID = 3L;
    String stringStandardCategoryParent = "path to parent category";

    String stringCustomCategoryName = "Custom Category Name";
    Long stringCustomCategoryID = 14L;
    String stringCustomCategoryParent = "path to parent category";
    String stringCustomCategoryFamilyID = "@tonyze@gmail.com";

    CategoryName standardCategoryName = new CategoryName(stringStandardCategoryName);
    CategoryID standardCategoryID = new CategoryID(stringStandardCategoryID);
    ParentCategoryPath standardCategoryParent = new ParentCategoryPath(stringStandardCategoryParent);

    CategoryName customCategoryName = new CategoryName(stringCustomCategoryName);
    CategoryID customCategoryID = new CategoryID(stringCustomCategoryID);
    ParentCategoryPath customCategoryParent = new ParentCategoryPath(stringCustomCategoryParent);
    FamilyID customCategoryFamilyID = new FamilyID(stringCustomCategoryFamilyID);

    Category standardCategory = new StandardCategory(standardCategoryName, standardCategoryID, standardCategoryParent);
    Category customCategory = new CustomCategory(customCategoryID,customCategoryParent, customCategoryName, customCategoryFamilyID);

    OutputCategoryDTO standardOutputCategoryDTO = new OutputCategoryDTO(stringStandardCategoryName, stringStandardCategoryID.toString(), stringStandardCategoryParent);
    OutputCategoryDTO customOutputCategoryDTO = new OutputCategoryDTO(stringCustomCategoryName, stringCustomCategoryID.toString(), stringCustomCategoryParent, stringCustomCategoryFamilyID);


    @Test
    void getCustomCategoriesEmptyList() {
        String familyID = "@tonyze@gmail.com";

        OutputCategoryTreeDTO expected = new OutputCategoryTreeDTO();

        when(categoryRepository.getCustomCategoryList(any(FamilyID.class))).thenReturn(new ArrayList<>());
        when(categoryRepository.getStandardCategoryList()).thenReturn(new ArrayList<>());

        OutputCategoryTreeDTO result = getCustomCategoriesService.getCustomCategories(familyID);

        assertEquals(expected, result);
    }

    //TODO: fazer teste em que recebe pelo menos uma standard e uma custom
    @Test
    void getCustomCategories() {
        String familyID = "@tonyze@gmail.com";

        OutputCategoryTreeDTO expected = new OutputCategoryTreeDTO();
        expected.addOutputCategoryDTO(standardOutputCategoryDTO);
        expected.addOutputCategoryDTO(customOutputCategoryDTO);

        List<Category> standardCategories = new ArrayList<>();
        standardCategories.add(standardCategory);

        List<Category> customCategories = new ArrayList<>();
        customCategories.add(customCategory);

        when(categoryRepository.getStandardCategoryList()).thenReturn(standardCategories);
        when(categoryRepository.getCustomCategoryList(any(FamilyID.class))).thenReturn(customCategories);
        when(categoryDTODomainAssembler.toDTO(standardCategory)).thenReturn(standardOutputCategoryDTO);
        when(categoryDTODomainAssembler.toDTO(customCategory)).thenReturn(customOutputCategoryDTO);

        OutputCategoryTreeDTO result = getCustomCategoriesService.getCustomCategories(familyID);

        assertEquals(expected, result);
    }


}