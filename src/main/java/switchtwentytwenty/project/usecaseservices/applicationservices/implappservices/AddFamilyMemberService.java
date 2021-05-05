package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
<<<<<<< HEAD
import switchtwentytwenty.project.domain.valueobject.*;
=======
import switchtwentytwenty.project.domain.valueobject.PersonID;
>>>>>>> 09a7206475d97e3abb174c7aee2d6ff3d0c3b222
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InAddFamilyMemberDTO;
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
<<<<<<< HEAD
    public void addPerson(InternalFamilyMemberDTO internalFamilyMemberDTO) {
        PersonID loggedUserID = new PersonID(userID);

=======
    public void addPerson(InAddFamilyMemberDTO InAddFamilyMemberDTO) {
        PersonID loggedUserID = new PersonID(InAddFamilyMemberDTO.getAdminID());
>>>>>>> 09a7206475d97e3abb174c7aee2d6ff3d0c3b222
        familyRepository.verifyAdmin(loggedUserID);
        Person person = personDTODomainAssembler.toDomain(InAddFamilyMemberDTO);
        personRepository.add(person);

    }
}