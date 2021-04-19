package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.PersonProfileDTO;

public interface IGetFamilyMemberProfileService {

    PersonProfileDTO getFamilyMemberProfile(String personID);

}
