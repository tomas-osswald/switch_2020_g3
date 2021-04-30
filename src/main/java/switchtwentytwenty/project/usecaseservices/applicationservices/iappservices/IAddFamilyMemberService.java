package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InputPersonDTO;

public interface IAddFamilyMemberService {

    public void addPerson(InputPersonDTO inputPersonDTO, String userID);

}
