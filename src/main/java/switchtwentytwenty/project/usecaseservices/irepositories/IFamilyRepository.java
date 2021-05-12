package switchtwentytwenty.project.usecaseservices.irepositories;

import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;


public interface IFamilyRepository extends Repository<Family, FamilyID> {

    //void verifyAdmin(PersonID adminID);

    //FamilyID generateID();

    @Override
    Family add(Family entity);

    void checkIfFamilyExists(FamilyID familyID);
}