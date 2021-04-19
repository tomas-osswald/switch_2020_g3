package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.ProfileOutputDTO;

public interface IGetFamilyMemberProfileService {

    ProfileOutputDTO getFamilyMemberProfile(String personID);

}
