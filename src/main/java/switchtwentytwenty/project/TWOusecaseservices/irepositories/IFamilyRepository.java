package switchtwentytwenty.project.TWOusecaseservices.irepositories;

import switchtwentytwenty.project.ONEdomain.aggregates.family.Family;
import switchtwentytwenty.project.ONEdomain.aggregates.person.Person;
import switchtwentytwenty.project.ONEdomain.valueobject.FamilyID;
import switchtwentytwenty.project.ONEdomain.valueobject.PersonID;

public interface IFamilyRepository extends Repository<Family, FamilyID> {

    void verifyAdmin(PersonID adminID);
}
