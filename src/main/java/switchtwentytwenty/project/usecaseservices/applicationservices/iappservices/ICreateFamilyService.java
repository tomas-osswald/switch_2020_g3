package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

public interface ICreateFamilyService {

    void createFamilyAndAddAdmin(CreateFamilyDTO createFamilyDTO, AddPersonFormDTO addPersonFormDTO);

}
