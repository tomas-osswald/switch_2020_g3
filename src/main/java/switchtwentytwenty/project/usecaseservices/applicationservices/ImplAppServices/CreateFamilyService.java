package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class CreateFamilyService {
    @Autowired
    IPersonRepository personRepository;
    @Autowired
    IFamilyRepository familyRepository;


    //TODO: Alterar SD de Boolean para Void
    public void createFamilyAndAddAdmin(CreateFamilyDTO createFamilyDTO, AddPersonFormDTO addPersonFormDTO) {
        PersonID adminID = new PersonID(addPersonFormDTO.unpackEmail());
        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());
        Name name = new Name(addPersonFormDTO.unpackName());
        BirthDate birthdate = new BirthDate(addPersonFormDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(addPersonFormDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonFormDTO.unpackPhone());
        Address address = new Address(addPersonFormDTO.unpackStreet(), addPersonFormDTO.unpackCity(), addPersonFormDTO.unpackZipCode(), addPersonFormDTO.unpackHouseNumber());
        RegistrationDate registrationDate = new RegistrationDate(createFamilyDTO.unpackLocalDate());

        if (!personRepository.isPersonIDAlreadyRegistered(adminID)) {

            FamilyID familyID = familyRepository.generateID();

            Family family = new Family(familyID, familyName, registrationDate, adminID);
            Person admin = new Person(name, birthdate, adminID, vat, phone, address, familyID);

            personRepository.addPerson(admin);
            familyRepository.addPerson(family);
        } else {
            throw new PersonAlreadyRegisteredException("This person is already registered in the Application");
        }
    }
}