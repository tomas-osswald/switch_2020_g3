package switchtwentytwenty.project.TWOusecaseservices.applicationservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.TWOusecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.TWOusecaseservices.irepositories.IPersonRepository;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.FamilyRepository;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.*;

@Service
public class AddFamilyMemberService {


    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IFamilyRepository familyRepository;


    public void addPerson(AddPersonDTO addPersonDTO) {
        PersonID loggedUserID = new PersonID(addPersonDTO.unpackUserID());
        familyRepository.verifyAdmin(loggedUserID);

        Name name = new Name(addPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(addPersonDTO.unpackBirthDate());
        PersonID idEmail = new PersonID(addPersonDTO.unpackEmail());
        VATNumber vat = new VATNumber(addPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(addPersonDTO.unpackPhone());
        Address address = new Address(addPersonDTO.unpackStreet(), addPersonDTO.unpackCity(), addPersonDTO.unpackZipCode(), addPersonDTO.unpackHouseNumber());


        FamilyID familyID = personRepository.getPersonFamilyID(loggedUserID);

        personRepository.createAndAddPerson(name, birthDate, idEmail, vat, phone, address, familyID);
    }
}
