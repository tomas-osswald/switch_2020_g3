package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;



import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.FamilyRepository;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.PersonRepository;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

public class CreateFamilyService {
    @Autowired
    IPersonRepository personRepository;
    @Autowired
    IFamilyRepository familyRepository;



    public boolean createFamilyAndAddAdmin(CreateFamilyDTO createFamilyDTO, AddPersonDTO addPersonDTO) {
        boolean result;
        PersonID adminID = new PersonID(addPersonDTO.unpackEmail());
        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());
        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthdate = new BirthDate(addPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());
        RegistrationDate registrationDate = new RegistrationDate(createFamilyDTO.unpackLocalDate());

        FamilyID familyID = familyRepository.generateID();

        Family family = new Family(familyID,familyName,registrationDate,adminID);
        Person admin = new Person(name,birthdate,adminID,vat,phone,address,familyID);

        try {
            personRepository.save(admin);
            familyRepository.save(family);
            result = true;
        } catch (EmailAlreadyRegisteredException e) {
            result = false;
        }
        return result;
    }
}