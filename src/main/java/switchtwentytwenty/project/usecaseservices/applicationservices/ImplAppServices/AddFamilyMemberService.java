package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddFamilyMemberService implements IAddFamilyMemberService {


    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IFamilyRepository familyRepository;


    /**
     * Added the PersonAlreadyRegisteredException in order to guarantee that if a person is already
     * registered in the App the method will fail and the Controller will catch this Exception. The Controller was receiving
     * a true even when the person was not added (line 40 was true)
     *
     * @param addPersonFormDTO
     */
    public void addPerson(AddPersonFormDTO addPersonFormDTO) {
        PersonID loggedUserID = new PersonID(addPersonFormDTO.unpackUserID());
        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(addPersonFormDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonFormDTO.unpackBirthDate());
        PersonID personID = new PersonID(addPersonFormDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonFormDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonFormDTO.unpackPhone());
        Address address = new Address(addPersonFormDTO.unpackStreet(), addPersonFormDTO.unpackCity(), addPersonFormDTO.unpackZipCode(), addPersonFormDTO.unpackHouseNumber());


        Person admin = personRepository.getByID(loggedUserID);
        FamilyID familyID = admin.getFamilyID();

        Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);
        personRepository.save(person);

    }
}


