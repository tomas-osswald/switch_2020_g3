package switchtwentytwenty.project.TWOusecaseservices.applicationservices;



import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.FamilyRepository;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.*;

public class CreateFamilyService {





    public boolean createFamilyAndAddAdmin(CreateFamilyDTO createFamilyDTO, AddPersonDTO addPersonDTO) {
        boolean result;
        PersonID adminEmail = new PersonID(addPersonDTO.unpackEmail());
        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());
        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthdate = new BirthDate(addPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());
        RegistrationDate registrationDate = new RegistrationDate(createFamilyDTO.unpackLocalDate());

        //TODO: meter os autowires do personRepository e familyRepository
        PersonRepository personRepository = null;
        FamilyRepository familyRepository = null;

        FamilyID familyID = familyRepository.generateAndGetFamilyID();
        familyRepository.createAndAddFamily(familyName, familyID, registrationDate, adminEmail);

        try {
            personRepository.createAndAddPerson(name, birthdate, adminEmail, vat, phone, address, familyID);
            result = true;
        } catch (EmailAlreadyRegisteredException e) {
            familyRepository.removeFamily(familyID);
            result = false;
        }
        return result;
    }
}
