package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.CategoryTreeDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.List;

@Service
public class GetStandardCategoryTreeService implements IGetStandardCategoryTreeService {

    private final ICategoryRepository categoryRepository;
    private final CategoryDTODomainAssembler categoryDTODomainAssembler;

    public GetStandardCategoryTreeService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryDTODomainAssembler = new CategoryDTODomainAssembler();
    }

    public CategoryTreeDTO getStandardCategoryTree(){
        List<Category> categoryList = categoryRepository.getStandardCategoryList();

        CategoryTreeDTO categoryTreeDTO = createStandardCategoryTreeDTO(categoryList);

        return categoryTreeDTO;
    }

    private CategoryTreeDTO createStandardCategoryTreeDTO(List<Category> categoryList){
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();

        for (Category category: categoryList) {

            OutputCategoryDTO outputCategoryDTO = categoryDTODomainAssembler.toDTO(category);
            categoryTreeDTO.getCategoryTreeDTO().add(outputCategoryDTO);
        }

        return categoryTreeDTO;
    }

}
