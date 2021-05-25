package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.category.CategoryTreeDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;

@Service
public class GetStandardCategoryTreeService implements IGetStandardCategoryTreeService {


    public CategoryTreeDTO getStandardCategoryTree(){
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();


        return categoryTreeDTO;
    }

}
