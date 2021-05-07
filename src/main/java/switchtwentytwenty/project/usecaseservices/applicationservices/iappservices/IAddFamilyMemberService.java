package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IAddFamilyMemberService {
    OutputPersonDTO addPerson(InternalFamilyMemberDTO internalFamilyMemberDTO);

}