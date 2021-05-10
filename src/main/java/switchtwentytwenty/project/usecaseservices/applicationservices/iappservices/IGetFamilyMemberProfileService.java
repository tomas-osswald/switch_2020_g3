package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.person.InputGetProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IGetFamilyMemberProfileService {

    OutputPersonDTO getFamilyMemberProfile(InputGetProfileDTO internalGetProfileDTO);

}
