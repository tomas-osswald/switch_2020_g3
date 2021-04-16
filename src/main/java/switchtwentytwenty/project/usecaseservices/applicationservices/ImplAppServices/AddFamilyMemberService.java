package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
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
     * @param addPersonDTO
     */
    public void addPerson(AddPersonDTO addPersonDTO) {
        PersonID loggedUserID = new PersonID(addPersonDTO.unpackUserID());
        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonDTO.unpackBirthDate());
        PersonID personID = new PersonID(addPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());

        if (!personRepository.isPersonIDAlreadyRegistered(personID)) {
            Person admin = personRepository.getByID(loggedUserID);
            FamilyID familyID = admin.getFamilyID();

            Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);
            personRepository.save(person);
        } else {
            throw new PersonAlreadyRegisteredException("This person already exists in the Application");
        }

    }
}