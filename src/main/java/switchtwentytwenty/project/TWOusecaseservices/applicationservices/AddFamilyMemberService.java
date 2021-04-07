package switchtwentytwenty.project.TWOusecaseservices.applicationservices;

import switchtwentytwenty.project.Application;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.FamilyRepository;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.*;

public class AddFamilyMemberService {

    private Application application;


    public AddFamilyMemberService(Application application) {
        this.application = application;

    }

    public void addPerson(AddPersonDTO addPersonDTO) {
        FamilyRepository familyRepository = application.getFamilyRepository();
        PersonID loggedUserID = application.getLoggedPersonID();
        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonDTO.unpackBirthDate());
        PersonID idEmail = new PersonID(addPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());


        FamilyID familyID = application.getLoggedPersonFamilyID();

        PersonRepository personRepository = application.getPersonRepository();
        personRepository.createAndAddPerson(name, birthDate, idEmail, vat, phone, address, familyID);
    }
}
