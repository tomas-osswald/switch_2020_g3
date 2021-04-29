package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddFamilyMemberService implements IAddFamilyMemberService {


    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IFamilyRepository familyRepository;
    @Autowired
    private PersonDTODomainAssembler personDTODomainAssembler;


    /**
     * Added the PersonAlreadyRegisteredException in order to guarantee that if a person is already
     * registered in the App the method will fail and the Controller will catch this Exception. The Controller was receiving
     * a true even when the person was not added (line 40 was true)
     *
     * @param inputPersonDTO
     */
    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public void addPerson(InputPersonDTO inputPersonDTO, String userID) {
        PersonID loggedUserID = new PersonID(userID);

        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(inputPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(inputPersonDTO.unpackBirthDate());
        PersonID personID = new PersonID(inputPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(inputPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(inputPersonDTO.unpackPhone());
        Address address = new Address(inputPersonDTO.unpackStreet(), inputPersonDTO.unpackCity(), inputPersonDTO.unpackZipCode(), inputPersonDTO.unpackHouseNumber());


        Person admin = personRepository.getByID(loggedUserID);
        FamilyID familyID = admin.getFamilyID();

        Person person = personDTODomainAssembler.toDomain(inputPersonDTO,familyID);
        personRepository.add(person);

    }
}


