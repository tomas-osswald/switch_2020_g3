package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.util.Repository;
import switchtwentytwenty.project.domain.family.Family;
import switchtwentytwenty.project.exceptions.UserIsNotAdminException;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.FamilyName;
import switchtwentytwenty.project.shared.RegistrationDate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FamilyRepository implements Repository<Family, FamilyID> {

    private final List<Family> families;
    //private final Families families = new Families();

    public FamilyRepository() {
        this.families = new ArrayList<>();
    }

    public void addFamily(Family family) {
        this.families.add(family);
    }

    // public Family findFamilyByID(FamilyID id){

    //}

    public void createAndAddFamily(FamilyName familyName, FamilyID familyID, RegistrationDate registrationDate, EmailAddress adminEmail) {
        Family family = new Family(familyID, familyName, registrationDate, adminEmail);
        this.families.add(family);
    }

    public FamilyID generateAndGetFamilyID() {
        //FamilyIDGenerator familyIDGenerator = new DefaultFamilyIDGenerator();
        //FamilyID familyID = familyIDGenerator.generateID();
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        if (checkIfFamilyIDExists(familyID)) {
            familyID = generateAndGetFamilyID();
        }
        return familyID;
    }

    private boolean checkIfFamilyIDExists(FamilyID familyID) {
        boolean result = false;
        for (Family family : this.families) {
            if (family.hasID(familyID)) {
                result = true;
            }
        }
        return result;
    }

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

    public void verifyAdmin(EmailAddress loggedUserID) {
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
    public EmailAddress getFirstAdminEmail() {
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

