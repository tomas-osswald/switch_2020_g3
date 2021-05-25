package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;

@Service
public interface IGetStandardCategoryTreeService {

    OutputCategoryTreeDTO getStandardCategoryTree();

}
