package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.List;

@Service
public class GetStandardCategoryTreeService implements IGetStandardCategoryTreeService {

    private final ICategoryRepository categoryRepository;
    private final ICategoryDTODomainAssembler categoryDTODomainAssembler;

    @Autowired
    public GetStandardCategoryTreeService(ICategoryRepository categoryRepository, ICategoryDTODomainAssembler categoryDTODomainAssembler) {
        this.categoryRepository = categoryRepository;
        this.categoryDTODomainAssembler = categoryDTODomainAssembler;
    }

    public OutputCategoryTreeDTO getStandardCategoryTree(){
        List<Category> categoryList = categoryRepository.getStandardCategoryList();

        OutputCategoryTreeDTO outputCategoryTreeDTO = createStandardCategoryTreeDTO(categoryList);

        return outputCategoryTreeDTO;
    }

    private OutputCategoryTreeDTO createStandardCategoryTreeDTO(List<Category> categoryList){
        OutputCategoryTreeDTO outputCategoryTreeDTO = new OutputCategoryTreeDTO();

        for (Category category: categoryList) {
            OutputCategoryDTO outputCategoryDTO = categoryDTODomainAssembler.toDTO(category);
            outputCategoryTreeDTO.addOutputCategoryDTO(outputCategoryDTO);
        }

        return outputCategoryTreeDTO;
    }

}
