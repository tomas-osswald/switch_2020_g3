package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.authentication.JWTokenUtil;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.family.FamilyMemberAndRelationsListDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMembersAndRelationshipService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;


import java.util.List;

@Service
public class GetFamilyMembersAndRelationshipService implements IGetFamilyMembersAndRelationshipService {

    FamilyDTODomainAssembler familyDTODomainAssembler;
    IFamilyRepository familyRepository;
    IPersonRepository personRepository;

    JWTokenUtil jwTokenUtil;


    @Autowired
    public GetFamilyMembersAndRelationshipService(FamilyDTODomainAssembler familyDTODomainAssembler, IPersonRepository personRepository, IFamilyRepository familyRepository, JWTokenUtil jwTokenUtil) {
        this.familyDTODomainAssembler = familyDTODomainAssembler;
        this.familyRepository = familyRepository;
        this.personRepository = personRepository;
        this.jwTokenUtil = jwTokenUtil;
    }


    @Override
    public FamilyMemberAndRelationsListDTO getFamilyMembersAndRelations(String familyID, String jwt) {
        FamilyID internalFamilyID = familyDTODomainAssembler.familyIDToDomain(familyID);
        Family family = familyRepository.getByID(internalFamilyID);
        validateAuthorization(family, jwt);
        List<Person> memberList = personRepository.findAllByFamilyID(internalFamilyID);
        FamilyMemberAndRelationsListDTO familyMemberAndRelationsListDTO = new FamilyMemberAndRelationsListDTO();
        for (Person person : memberList) {
            familyMemberAndRelationsListDTO.addDTO(familyDTODomainAssembler.createFamilyMemberAndRelationsDTO(person, family));
        }
        return familyMemberAndRelationsListDTO;
    }

    private void validateAuthorization(Family family, String jwt) {
        String personName = jwTokenUtil.extractUsernameFromHeader(jwt);
        PersonID adminID = new PersonID(personName);
        if (!family.isPersonTheAdmin(adminID)) {
            throw new AccessDeniedException("Not a Family Administrator");
        }
    }
}
