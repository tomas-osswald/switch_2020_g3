package switchtwentytwenty.project.usecaseservices.irepositories;

import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

public interface IPersonRepository extends Repository <Person, PersonID>{

    FamilyID getPersonFamilyID(PersonID personID);

    Person add(Person entity);

    void createAndAdd(Name name, BirthDate birthDate, PersonID personID, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID);

    boolean isPersonIDAlreadyRegistered(PersonID personID);

    Person updatePerson(Person person);

}