package switchtwentytwenty.project.dataaccesslayer;


import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.shared.*;

import java.time.LocalDate;

public class CreateFamilyService {

    private Application application;

    public CreateFamilyService(Application application) {
        this.application = application;
    }

    public boolean createFamilyAndAddAdmin(CreateFamilyDTO createFamilyDTO, AddPersonDTO addPersonDTO) {
        boolean result;
        EmailAddress adminEmail = new EmailAddress(addPersonDTO.unpackEmail());
        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());
        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthdate = new BirthDate(addPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());
        CCnumber cc = new CCnumber(addPersonDTO.unpackCCNumber());
        RegistrationDate registrationDate = new RegistrationDate(createFamilyDTO.unpackLocalDate());

        PersonRepository personRepository = application.getPersonRepository();
        FamilyRepository familyRepository = application.getFamilyRepository();

        FamilyID familyID = familyRepository.generateAndGetFamilyID();
        familyRepository.createAndAddFamily(familyName, familyID, registrationDate, adminEmail);

        try {
            personRepository.createAndAddPerson(name, birthdate, adminEmail, vat, phone, address, cc, familyID);
            result = true;
        } catch (EmailAlreadyRegisteredException e) {
            familyRepository.removeFamily(familyID);
            result = false;
        }
        return result;
    }
}
