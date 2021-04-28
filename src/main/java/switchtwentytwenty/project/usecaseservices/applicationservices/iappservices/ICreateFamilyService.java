package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.OutputFamilyDTO;

public interface ICreateFamilyService {

    OutputFamilyDTO createFamilyAndAddAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO);

}
