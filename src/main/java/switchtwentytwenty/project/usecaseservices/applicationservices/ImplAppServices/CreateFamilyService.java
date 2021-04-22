package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class CreateFamilyService implements ICreateFamilyService {

    private IPersonRepository personRepository;
    private IFamilyRepository familyRepository;

    @Autowired
    public CreateFamilyService(IPersonRepository personRepository, IFamilyRepository familyRepository){
        this.personRepository = personRepository;
        this.familyRepository = familyRepository;
    }

    //TODO: Alterar SD de Boolean para Void
    public void createFamilyAndAddAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO) {
        PersonID adminID = new PersonID(inputPersonDTO.unpackEmail());
        FamilyName familyName = new FamilyName(inputFamilyDTO.unpackFamilyName());
        Name name = new Name(inputPersonDTO.unpackName());
        BirthDate birthdate = new BirthDate(inputPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(inputPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(inputPersonDTO.unpackPhone());
        Address address = new Address(inputPersonDTO.unpackStreet(), inputPersonDTO.unpackCity(), inputPersonDTO.unpackZipCode(), inputPersonDTO.unpackHouseNumber());
        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());

        FamilyID familyID = familyRepository.generateID();
        Person admin = new Person(name, birthdate, adminID, vat, phone, address, familyID);

        personRepository.add(admin);

        Family family = new Family(familyID, familyName, registrationDate, adminID);

        familyRepository.add(family);

    }
}