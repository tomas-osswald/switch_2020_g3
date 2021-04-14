package switchtwentytwenty.project.interfaceadapters.ImplRepositories;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.exceptions.UserIsNotAdminException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FamilyRepository implements IFamilyRepository {

    private final List<Family> families;
    //private final Families families = new Families();

    public FamilyRepository() {
        this.families = new ArrayList<>();
    }

    @Deprecated
    public void createAndAdd(FamilyName familyName, FamilyID familyID, RegistrationDate registrationDate, PersonID adminEmail) {
        Family family = new Family(familyID, familyName, registrationDate, adminEmail);
        this.families.add(family);
    }

    /**
     *
     * @return familyID
     */
    public FamilyID generateID() {
        //FamilyIDGenerator familyIDGenerator = new DefaultFamilyIDGenerator();
        //FamilyID familyID = familyIDGenerator.generateID();
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        if (checkIfIDExists(familyID)) {
            familyID = generateID();
        }
        return familyID;
    }

    @Override
    public void save(Family family) {
        this.families.add(family);
    }

    private boolean checkIfIDExists(FamilyID familyID) {
        boolean result = false;
        for (Family family : this.families) {
            if (family.hasID(familyID)) {
                result = true;
            }
        }
        return result;
    }

    // In create family and set admin family is no longer created before the person and no longer needs to be removed if person cannot be created
    @Deprecated
    public void removeFamily(FamilyID familyID) {
        Family family = getByID(familyID);
        if (family != null) {
            this.families.remove(family);
        }
    }

    public Family getByID(FamilyID familyID) {
        Family targetFamily = null;
        for (Family family : this.families) {
            if (family.hasID(familyID)) {
                targetFamily = family;
            }
        }
        return targetFamily;
    }

    public void verifyAdmin(PersonID loggedUserID) {
        boolean result = false;
        for (Family family : this.families) {
            if(family.isPersonTheAdmin(loggedUserID)){
                result = true;
            }
        }
        if(!result){
            throw new UserIsNotAdminException();
        }
    }

    @Deprecated
    public PersonID getFirstAdminEmail() {
        return this.families.get(0).getAdminEmail();
    }



    /*
    v1
    EmailAddress;
    new Family(DTO, EmailAddress);
    new Admin(DTO, EmailAddress, idfamily);
    verifyIfPresent;
    add Admin to repo;
    add family to repo;

    v2
    EmailAddress;
    verifyIFPresent;
    new Admin(DTO1,email);
    add Admin;
    new Family(DTO2,email);
    add Family; or remove Admin;
    set familyID in Admin;
    */

 /*   private class Families implements Iterable<Family>{
        private final List<Family> families;

        private Families(){
            this.families = new ArrayList<>();
        }

        public Iterator<Family> iterator(){
            return this.families.iterator();
        }
    }*/
}