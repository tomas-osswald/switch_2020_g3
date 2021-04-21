package switchtwentytwenty.project.datamodel.assemblerjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.PersonJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AddressJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

@Component
public class PersonDataDomainAssembler {

    public PersonJPA toData(Person person) {
        PersonJPA personJPA = new PersonJPA();

        return personJPA;
    }

    public Person toDomain (PersonJPA personJPA, AddressJPA addressJPA) {
        PersonID personID = new PersonID(personJPA.getId().toString());
        Name name = new Name(personJPA.getName());
        BirthDate birthDate = new BirthDate(personJPA.getBirthDate());
        VATNumber vatNumber = new VATNumber(personJPA.getVatNumber());
        FamilyID familyID = new FamilyID(personJPA.getFamilyID().toString());
        Address address = new AddressJPA(addressJPA.getStreet(), addressJPA.getCity(), addressJPA.getZipCode(), addressJPA.getNumber())

        Person person = new Person(personID, name, birthDate, vatNumber, familyID);

        person.setAddress(address);

        return person;
    }
}
