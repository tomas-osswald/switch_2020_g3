package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.authentication.JWTokenUtil;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.InputGetProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;


@Service
public class GetFamilyMemberProfileService implements IGetFamilyMemberProfileService {

    IPersonRepository personRepository;

    PersonDTODomainAssembler assembler;

    @Autowired
    JWTokenUtil jwTokenUtil;

    @Autowired
    public GetFamilyMemberProfileService(IPersonRepository iPersonRepository, PersonDTODomainAssembler personDTODomainAssembler) {
        this.assembler = personDTODomainAssembler;
        this.personRepository = iPersonRepository;
    }

    public OutputPersonDTO getFamilyMemberProfile(InputGetProfileDTO internalGetProfileDTO) throws AccessDeniedException {
        String userName = jwTokenUtil.getUsernameFromToken(internalGetProfileDTO.unpackJWT().substring(7));

        PersonID userID = new PersonID(userName);

        PersonID personID = assembler.createPersonID(internalGetProfileDTO);

        if(!userID.equals(personID)) throw new AccessDeniedException("Forbidden");
        Person person = personRepository.getByID(personID);

        return assembler.toDTO(person);
    }

}
