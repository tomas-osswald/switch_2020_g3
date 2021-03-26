package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.shared.*;

public class AddPersonService {

    private Application application;


    public AddPersonService(Application application) {
        this.application = application;

    }

    public void addPerson(AddPersonDTO addPersonDTO) {
        FamilyRepository familyRepository = application.getFamilyRepository();
        EmailAddress loggedUserID = application.getLoggedPersonID();
        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonDTO.unpackBirthDate());
        EmailAddress email = new EmailAddress(addPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());
        CCnumber cc = new CCnumber(addPersonDTO.unpackCCNumber());
        FamilyID familyID = application.getLoggedPersonFamilyID();

        PersonRepository personRepository = application.getPersonRepository();
        personRepository.createAndAddPerson(name, birthDate, email, vat, phone, address, cc, familyID);
    }
}
