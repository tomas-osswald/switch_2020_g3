package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

class CreateStandardCategoryServiceTest {

    @Mock
    ICategoryRepository iCategoryRepository;
    @Mock
    ICategoryDTODomainAssembler iCategoryDTODomainAssembler;

    @InjectMocks
    switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.CreateStandardCategoryService createStandardCategoryService;

    @Test
    void createStandardCategory() {


    }
}