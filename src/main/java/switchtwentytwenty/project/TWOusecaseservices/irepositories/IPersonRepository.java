package switchtwentytwenty.project.TWOusecaseservices.irepositories;

import switchtwentytwenty.project.ONEdomain.aggregates.person.Person;
import switchtwentytwenty.project.ONEdomain.valueobject.*;
import switchtwentytwenty.project.TWOusecaseservices.irepositories.Repository;

public interface IPersonRepository extends Repository <Person, PersonID>{

    FamilyID getPersonFamilyID(PersonID personID);

    void createAndAddPerson(Name name, BirthDate birthDate, PersonID idEmail, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID);
}
