package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateStandardCategoryServiceTest {

    @Mock
    ICategoryRepository iCategoryRepository;
    @Mock
    ICategoryDTODomainAssembler iCategoryDTODomainAssembler;

    @InjectMocks
    CreateStandardCategoryService createStandardCategoryService;

    @Test
    void createStandardCategory() {


    }


}