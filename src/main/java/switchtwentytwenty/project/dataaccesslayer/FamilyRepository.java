package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.Repository;
import switchtwentytwenty.project.domain.family.Family;
import switchtwentytwenty.project.shared.FamilyName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepository implements Repository {

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

    public void createFamily(String name, LocalDate registrationDate) {
        FamilyName familyName = new FamilyName(name);

        //generateID();
        //Family newFamily = new Family(familyName,registrationDate,familyID);
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
