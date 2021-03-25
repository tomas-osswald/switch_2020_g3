package switchtwentytwenty.project.dataaccesslayer;


import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.shared.*;

import java.time.LocalDate;

public class CreateFamilyService {

    private Application application;
    private CreateFamilyDTO createFamilyDTO;

    public CreateFamilyService(CreateFamilyDTO createFamilyDTO, Application application) {
        this.createFamilyDTO = createFamilyDTO;
        this.application = application;
    }

    public void createFamilyAndAddAdmin() {
        EmailAddress adminEmail = new EmailAddress(createFamilyDTO.unpackAdminEmail());
        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());
        Name name = new Name(createFamilyDTO.unpackName());
        BirthDate birthdate = new BirthDate(createFamilyDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(createFamilyDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(createFamilyDTO.unpackPhone());
        Address address = new Address(createFamilyDTO.unpackStreet(), createFamilyDTO.unpackCity(), createFamilyDTO.unpackZipCode(), createFamilyDTO.unpackHouseNumber());
        CCnumber cc = new CCnumber(createFamilyDTO.unpackCCNumber());
        RegistrationDate registrationDate = new RegistrationDate(LocalDate.now());

        PersonRepository personRepository = application.getPersonRepository();
        FamilyRepository familyRepository = application.getFamilyRepository();

        FamilyID familyID = familyRepository.generateAndGetFamilyID();
        familyRepository.createAndAddFamily(familyName, familyID, registrationDate, adminEmail);

        try {
            personRepository.createAndAddPerson(name, birthdate, adminEmail, vat, phone, address, cc, familyID);
        }catch (EmailAlreadyRegisteredException e){
            familyRepository.removeFamily(familyID);
            throw new EmailAlreadyRegisteredException();
        }

    }
}
