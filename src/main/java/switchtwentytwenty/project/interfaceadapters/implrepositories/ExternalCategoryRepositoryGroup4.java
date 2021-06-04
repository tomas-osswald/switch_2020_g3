package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.IExternalCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExternalCategoryRepositoryGroup4 implements IExternalCategoryRepository {

    private ICategoryDTODomainAssembler categoryAssembler;

    /*
    public List<TaskDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, TaskDTO[].class)).collect(Collectors.toList());
    }
     */

    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();

        return categoryList;
    }
}
