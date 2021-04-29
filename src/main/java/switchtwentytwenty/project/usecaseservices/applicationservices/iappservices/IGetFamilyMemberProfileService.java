package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IGetFamilyMemberProfileService {

    OutputPersonDTO getFamilyMemberProfile(String personID);

}
