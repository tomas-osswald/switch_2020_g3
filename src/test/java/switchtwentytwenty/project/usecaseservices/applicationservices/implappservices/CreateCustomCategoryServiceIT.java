package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.category.CategoryFactory;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateCustomCategoryServiceIT {

    CreateCustomCategoryService createCustomCategoryService;

    @Mock
    ICategoryDTODomainAssembler categoryAssembler;

    @Mock
    CategoryFactory categoryFactory;

    @InjectMocks
    ICategoryRepository categoryRepository;

    @Autowired
    CategoryDTODomainAssembler categoryDTODomainAssembler;

}