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

    private final static String ACCESS_DENIED_MESSAGE = "Forbidden";

    IPersonRepository personRepository;

    PersonDTODomainAssembler assembler;

    @Autowired
    JWTokenUtil jwTokenUtil;

    @Autowired
    public GetFamilyMemberProfileService(IPersonRepository iPersonRepository, PersonDTODomainAssembler personDTODomainAssembler) {
        this.assembler = personDTODomainAssembler;
        this.personRepository = iPersonRepository;
    }

    public OutputPersonDTO getFamilyMemberProfile(InputGetProfileDTO inputGetProfileDTO) {
        validateAuthorization(inputGetProfileDTO);
        PersonID personID = assembler.createPersonID(inputGetProfileDTO);
        Person person = personRepository.getByID(personID);
        return assembler.toDTO(person);
    }

    private void validateAuthorization(InputGetProfileDTO inputGetProfileDTO) throws AccessDeniedException {
        String userName = jwTokenUtil.extractUsernameFromHeader(inputGetProfileDTO.unpackJWT());
        PersonID userID = assembler.createPersonID(userName);
        PersonID personID = assembler.createPersonID(inputGetProfileDTO);
        if (!userID.equals(personID)) throw new AccessDeniedException(ACCESS_DENIED_MESSAGE);
    }

}