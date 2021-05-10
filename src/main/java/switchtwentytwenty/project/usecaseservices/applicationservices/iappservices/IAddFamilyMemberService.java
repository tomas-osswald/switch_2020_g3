package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IAddFamilyMemberService {
    OutputPersonDTO addPerson(InternalAddFamilyMemberDTO internalAddFamilyMemberDTO);

}