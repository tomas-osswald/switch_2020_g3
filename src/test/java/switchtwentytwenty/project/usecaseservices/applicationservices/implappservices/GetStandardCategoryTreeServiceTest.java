package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.List;

class GetStandardCategoryTreeServiceTest {

    @Mock
    ICategoryRepository mockCategoryRepository;

    @Mock
    CategoryDTODomainAssembler mockCategoryDTODomainAssembler;

    @InjectMocks
    GetStandardCategoryTreeService getStandardCategoryTreeService;

    @Mock
    List<Category> mockCategoryList;

    @Mock
    Category mockCategory;

    @Mock
    OutputCategoryDTO mockOutputCategoryDTO;


    String categoryName1 = "Bebedeira";
    String categoryID1 = "17";
    String parentID1 = "5";
    OutputCategoryDTO outputCategoryDTO1 = new OutputCategoryDTO(categoryName1, categoryID1, parentID1);

    String categoryName2 = "Jantares";
    String categoryID2 = "18";
    String parentID2 = "5";
    OutputCategoryDTO outputCategoryDTO2 = new OutputCategoryDTO(categoryName2, categoryID2, parentID2);

    @Test
    @DisplayName("Get Standard category Tree successfully")
    void getStandardCategoryTree_Success() {
        /*
        when(mockCategoryRepository.getStandardCategoryList()).thenReturn(mockCategoryList);
        when(mockCategoryDTODomainAssembler.toDTO(any(Category.class))).thenReturn(mockOutputCategoryDTO);

        OutputCategoryTreeDTO outputCategoryTreeDTO = getStandardCategoryTreeService.getStandardCategoryTree();

        OutputCategoryTreeDTO expected = new OutputCategoryTreeDTO();
        expected.addOutputCategoryDTO(outputCategoryDTO1);
        expected.addOutputCategoryDTO(outputCategoryDTO2);

        assertEquals(expected, outputCategoryTreeDTO);

         */
    }

    @Test
    @DisplayName("Fail to get Standard category Tree")
    void getStandardCategoryTree_Fail() {
    }
}