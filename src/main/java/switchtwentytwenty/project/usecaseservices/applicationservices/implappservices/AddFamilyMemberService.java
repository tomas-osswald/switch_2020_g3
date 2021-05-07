package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;

import switchtwentytwenty.project.domain.valueobject.PersonID;

import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddFamilyMemberService implements IAddFamilyMemberService {

    private IPersonRepository personRepository;
    private IFamilyRepository familyRepository;
    private PersonDTODomainAssembler personDTODomainAssembler;

    @Autowired
    public AddFamilyMemberService(IPersonRepository personRepository, IFamilyRepository familyRepository) {
        this.personRepository = personRepository;
        this.familyRepository = familyRepository;
    }

    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public void addPerson(InternalFamilyMemberDTO internalFamilyMemberDTO) {
        PersonID loggedUserID = new PersonID(internalFamilyMemberDTO.getAdminID());

        familyRepository.verifyAdmin(loggedUserID);
        Person person = personDTODomainAssembler.toDomain(internalFamilyMemberDTO);
        personRepository.add(person);

    }
}