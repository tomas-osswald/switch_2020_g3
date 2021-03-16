package switchtwentytwenty.project.domain;

import switchtwentytwenty.project.domain.family.Family;
import switchtwentytwenty.project.domain.shared.FamilyID;
import switchtwentytwenty.project.domain.shared.FamilyName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepository {

    private final List<Family> families;
    //private final Families families = new Families();

    public FamilyRepository(){
        this.families = new ArrayList<>();
    }

    public void addFamily(Family family){
        this.families.add(family);
    }

   // public Family findFamilyByID(FamilyID id){

    //}

    public void createFamily(String name, LocalDate registrationDate){
        FamilyName familyName = new FamilyName(name);
        //generateID();
        //Family newFamily = new Family(familyName,registrationDate,familyID);
    }


 /*   private class Families implements Iterable<Families>{
        private final List<Family> families;

        private Families(){
            this.families = new ArrayList<>();
        }

        public Iterator iterator(){
            return this.families.iterator();
        }
    }*/
}