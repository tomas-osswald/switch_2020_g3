package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.category.CategoryTreeDTO;

@Service
public interface IGetStandardCategroyTreeService {

    CategoryTreeDTO getStandardCategoryTree();

}
