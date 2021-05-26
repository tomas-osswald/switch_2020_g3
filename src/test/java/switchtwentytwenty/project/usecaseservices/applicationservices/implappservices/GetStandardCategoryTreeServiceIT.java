package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class GetStandardCategoryTreeServiceIT {

    @Autowired
    ICategoryDTODomainAssembler categoryDTODomainAssembler;

    IGetStandardCategoryTreeService service;

    @InjectMocks
    ICategoryRepository categoryRepository;

    @Mock
    ICategoryRepositoryJPA categoryRepositoryJPA;

    @Mock
    ICategoryDataDomainAssembler categoryDataDomainAssembler;

    @Mock
    List<CategoryJPA> categoryJPAList;


    // OutputCategoryDTO 1
    String categoryName1 = "Bebedeira";
    String categoryID1 = "17L";
    String parentID1 = "5";
    OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO(categoryName1, categoryID1, parentID1);

    // OutputCategoryDTO 2
    String categoryName2 = "Jantares";
    String categoryID2 = "18L";
    String parentID2 = "5";
    OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO(categoryName2, categoryID2, parentID2);

    // Category 1
    Long categoryID1long = 17L;
    CategoryName categoryName1x = new CategoryName(categoryName1);
    CategoryID categoryID1x = new CategoryID(categoryID1long);
    ParentCategoryPath parentCategoryPath1x = new ParentCategoryPath(parentID1);

    // Category 2
    Long categoryID2long = 18L;
    CategoryName categoryName2x = new CategoryName(categoryName2);
    CategoryID categoryID2x = new CategoryID(categoryID2long);
    ParentCategoryPath parentCategoryPath2x = new ParentCategoryPath(parentID2);

    // CategoryList
    List<Category> categoryList = new ArrayList<>();

    @DisplayName("Get Standard Category Tree Successfully")
    @org.junit.jupiter.api.Test
    void getStandardCategoryTree() {

        // Get CategoryJPA list
        when(categoryRepositoryJPA.findAllByFamilyIDJPAIsNull()).thenReturn(categoryJPAList);

        // Create Value Objects Category 1 from Data to Domain
        when(categoryDataDomainAssembler.createCategoryID(any(CategoryJPA.class))).thenReturn(categoryID1x);
        when(categoryDataDomainAssembler.createCategoryName(any(CategoryJPA.class))).thenReturn(categoryName1x);
        when(categoryDataDomainAssembler.createParentID(any(CategoryJPA.class))).thenReturn(parentCategoryPath1x);

        // Create Value Objects Category 2 from Data to Domain
        when(categoryDataDomainAssembler.createCategoryID(any(CategoryJPA.class))).thenReturn(categoryID2x);
        when(categoryDataDomainAssembler.createCategoryName(any(CategoryJPA.class))).thenReturn(categoryName2x);
        when(categoryDataDomainAssembler.createParentID(any(CategoryJPA.class))).thenReturn(parentCategoryPath2x);

        // Create Category 1 and 2
        Category category1 = new StandardCategory(categoryName1x, categoryID1x, parentCategoryPath1x);
        Category category2 = new StandardCategory(categoryName2x, categoryID2x, parentCategoryPath2x);

        // Add Categories to List
        categoryList.add(category1);
        categoryList.add(category2);

        when(categoryRepository.getStandardCategoryList()).thenReturn(categoryList);

        service = new GetStandardCategoryTreeService(categoryRepository, categoryDTODomainAssembler);

        //OutputCategoryTreeDTO expected = service.getStandardCategoryTree();

        OutputCategoryTreeDTO result = new OutputCategoryTreeDTO();
        result.addOutputCategoryDTO(outputCategoryDTO1);
        result.addOutputCategoryDTO(outputCategoryDTO2);

        assertDoesNotThrow(()-> service.getStandardCategoryTree());
    }
}