package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CategoryFactory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateStandardCategoryServiceTest {

    @Mock
    ICategoryRepository categoryRepository;

    @Mock
    ICategoryDTODomainAssembler categoryDTODomainAssembler;

    @Mock
    CategoryFactory categoryFactory;

    @InjectMocks
    CreateStandardCategoryService createStandardCategoryService;

    @Test
    void createStandardCategorySuccess() {
        CategoryName categoryName = new CategoryName("Casa");
        when(categoryDTODomainAssembler.createCategoryName(anyString())).thenReturn(categoryName);
        when(categoryDTODomainAssembler.createParentCategoryPath(anyString())).thenReturn(new ParentCategoryPath("/sadsd"));
        when(categoryFactory.createCategory(any(CategoryName.class), any(ParentCategoryPath.class))).thenReturn(new StandardCategory());
        when(categoryRepository.add(any(Category.class))).thenReturn(new StandardCategory());

    }
}