package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CategoryFactory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.assemblers.implassemblers.ExternalCategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.ExternalStandardCategoryGroupFourDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IExternalCategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExternalCategoryRepositoryGroup4 implements IExternalCategoryRepository {

    private final ExternalCategoryDTODomainAssembler externalCategoryDTODomainAssembler;

    private final CategoryFactory categoryFactory;

    private RestTemplate restTemplate;

    //TODO está hardcoded, é preciso alterar para ser DI-nâ-MI-coooo
    //@Value("http://vs260.dei.isep.ipp.pt:8080/api/categories/")
    private final String resource = "http://vs260.dei.isep.ipp.pt:8080/api/categories/";

    @Autowired
    public ExternalCategoryRepositoryGroup4(ExternalCategoryDTODomainAssembler externalCategoryDTODomainAssembler, CategoryFactory categoryFactory) {
        this.externalCategoryDTODomainAssembler = externalCategoryDTODomainAssembler;
        this.categoryFactory = categoryFactory;
    }


    private List<ExternalStandardCategoryGroupFourDTO> findAll() {
        restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject(resource, ExternalStandardCategoryGroupFourDTO[].class)).collect(Collectors.toList());
    }

    private Category createCategory(ExternalStandardCategoryGroupFourDTO externalStandardCategoryGroupFourDTO) {

        CategoryName name = externalCategoryDTODomainAssembler.createCategoryName(externalStandardCategoryGroupFourDTO);
        CategoryID id = externalCategoryDTODomainAssembler.createCategoryID(externalStandardCategoryGroupFourDTO);
        ParentCategoryPath parentID = externalCategoryDTODomainAssembler.createParentID(externalStandardCategoryGroupFourDTO);

        return categoryFactory.createCategory(name, id, parentID);
    }


    public List<Category> getCategoryList() {
        List<ExternalStandardCategoryGroupFourDTO> externalStandardCategoryGroupFourDTOSList = findAll();

        List<Category> categoryList = new ArrayList<>();

        for (ExternalStandardCategoryGroupFourDTO externalStandardCategoryGroupFourDTOS : externalStandardCategoryGroupFourDTOSList) {
            Category category = createCategory(externalStandardCategoryGroupFourDTOS);
            categoryList.add(category);
        }

        return categoryList;
    }
}
