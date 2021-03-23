package switchtwentytwenty.project.domain;

import switchtwentytwenty.project.Repository;
import switchtwentytwenty.project.domain.family.Family;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.FamilyName;
import switchtwentytwenty.project.shared.RegistrationDate;
import switchtwentytwenty.project.util.FamilyIDFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepository implements Repository {

    private final List<Family> families;
    private CategoryRepository categoryRepository;
    private FamilyIDFactory familyIDFactory = new FamilyIDFactory();
    //private final Families families = new Families();

    public FamilyRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.families = new ArrayList<>();
    }

    public void addFamily(Family family) {
        this.families.add(family);
    }

    // public Family findFamilyByID(FamilyID id){

    //}

    public void createFamily(String name, LocalDate registrationDate, String adminEmail) {
        FamilyName familyName = new FamilyName(name);
        FamilyID familyID = generateID();
        EmailAddress adminEmailAddress = new EmailAddress(adminEmail);
        RegistrationDate registrationDateObject = new RegistrationDate(registrationDate);
        Family newFamily = new Family(familyID, familyName, registrationDateObject, adminEmailAddress);
        this.families.add(newFamily);
    }

    private FamilyID generateID() {
        FamilyID familyID = new FamilyID(this.familyIDFactory.generateFamilyID());
        return familyID;
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
