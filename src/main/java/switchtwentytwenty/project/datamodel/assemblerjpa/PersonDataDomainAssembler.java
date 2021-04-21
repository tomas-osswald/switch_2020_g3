package switchtwentytwenty.project.datamodel.assemblerjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.AddressJPA;
import switchtwentytwenty.project.datamodel.EmailAddressJPA;
import switchtwentytwenty.project.datamodel.PersonJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

@Component
public class PersonDataDomainAssembler {

    public PersonJPA toData(Person person) {
        PersonID personID = person.id();

        PersonIDJPA personIDJPA = new PersonIDJPA(personID.toString());

        String name = person.getName().toString();
        String birthdate = person.getBirthdate().toString();
        //List<EmailAddressJPA> emails = generateEmailAddressJPAList(person);
        int vat = person.getVat().toInt();
        List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
        AddressJPA addressJPA = new AddressJPA(person.getAddress());
        FamilyID familyID = person.getFamilyID();

        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.getFamilyID().toString());


        PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, addressJPA, familyIDJPA);

        return null; //personJPA;
    }

    public Person toDomain(PersonJPA personJPA, AddressJPA addressJPA) {
        PersonID personID = new PersonID(personJPA.getId().toString());
        Name name = new Name(personJPA.getName());
        BirthDate birthDate = new BirthDate(personJPA.getBirthdate());
        VATNumber vatNumber = new VATNumber(personJPA.getVat());
        FamilyID familyID = new FamilyID(personJPA.getFamilyid().toString());
        Address address = new Address(addressJPA.getStreet(), addressJPA.getCity(), addressJPA.getZipCode(), addressJPA.getDoorNumber());

        Person person = new Person(personID, name, birthDate, vatNumber, familyID);

        person.setAddress(address);

        return person;
    }
}
