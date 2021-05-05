package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InternalProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IGetFamilyMemberProfileService {

    OutputPersonDTO getFamilyMemberProfile(InternalProfileDTO internalProfileDTO);

}
