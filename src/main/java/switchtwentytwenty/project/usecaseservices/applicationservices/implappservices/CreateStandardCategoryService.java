package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

@Service
public class CreateStandardCategoryService implements ICreateStandardCategoryService {

    private ICategoryDTODomainAssembler categoryDTODomainAssembler;
    private ICategoryRepository categoryRepository;
    
    @Autowired
    public CreateStandardCategoryService(ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.categoryDTODomainAssembler = new CategoryDTODomainAssembler();
    }

    @Override
    public OutputCategoryDTO createStandardCategory(InputCategoryDTO inputCategoryDTO) {
        CategoryName categoryName = categoryDTODomainAssembler.createCategoryName(inputCategoryDTO.getCategoryName());
        ParentCategoryPath parentCategory = categoryDTODomainAssembler.createParentCategoryPath(inputCategoryDTO.getParentID());

        Category category = new StandardCategory(categoryName,parentCategory);

        Category savedStandardCategory = categoryRepository.add(category);

        OutputCategoryDTO outputCategoryDTO = categoryDTODomainAssembler.toDTO(savedStandardCategory);

        return outputCategoryDTO;
    }
}