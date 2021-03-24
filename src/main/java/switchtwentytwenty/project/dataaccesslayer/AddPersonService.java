package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.domain.person.Person;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.shared.*;

public class AddPersonService {

    private Application application;
    private AddPersonDTO addPersonDTO;

    public AddPersonService(AddPersonDTO addPersonDTO, Application application) {
        this.application = application;
        this.addPersonDTO = addPersonDTO;
    }

    public void addPerson() {
        FamilyRepository familyRepository = application.getFamilyRepository();
        Person loggedUser = application.getLoggedPerson();
        familyRepository.verifyAdmin(loggedUser);

        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonDTO.unpackBirthDate());
        EmailAddress email = new EmailAddress(addPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());
        CCnumber cc = new CCnumber(addPersonDTO.unpackCCNumber());
        FamilyID familyID = loggedUser.getFamilyID();

        PersonRepository personRepository = application.getPersonRepository();
        personRepository.createAndAddPerson(name, birthDate, email, vat, phone, address, cc, familyID);
    }
}
