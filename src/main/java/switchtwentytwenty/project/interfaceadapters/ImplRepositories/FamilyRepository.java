package switchtwentytwenty.project.interfaceadapters.ImplRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
import switchtwentytwenty.project.exceptions.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

import java.util.*;

@Repository
public class FamilyRepository implements IFamilyRepository {

    private final List<Family> families;
    private Map<FamilyID, Family> familyMap = new HashMap<>();
    @Autowired
    private IFamilyRepositoryJPA familyRepositoryJPA;
    @Autowired
    private FamilyDataDomainAssembler familyAssembler;

    //private final Families families = new Families();

    public FamilyRepository() {
        this.families = new ArrayList<>();
    }

    @Deprecated
    public void createAndAdd(FamilyName familyName, FamilyID familyID, RegistrationDate registrationDate, PersonID adminEmail) {
        Family family = new Family(familyID, familyName, registrationDate, adminEmail);
        this.families.add(family);
    }

    /**Method to generate a FamilyID domain object.
     * @return familyID
     * This method uses a recursive call to generate a unique ID after checking if it's not already registered.
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

    /**
     * Method to add a Family domain object to the repository.
     * The Family domain object will be converted into a FamilyJPA data object and saved in the repository.
     *
     * @param family domain object we want to add to the family repository
     */
    @Override
    public void add(Family family) {
        FamilyJPA familyJPA = familyAssembler.toData(family);
        familyRepositoryJPA.save(familyJPA);
    }

    /**
     * Method to check if there is already a Family in the database with a specific FamilyID. Used to ensure
     * that the familyID is unique, despite being randomly generated.
     * @param familyID domain object that we want to check the existence of
     * @return true if the FamilyID is already associated with a family.
     */
    private boolean checkIfIDExists(FamilyID familyID){
        boolean result = false;
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.toString());
        Optional<FamilyJPA> familyJPA = familyRepositoryJPA.findById(familyIDJPA);
        result = familyJPA.isPresent();
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

    /**
     * Method to retrieve a Family domain object by presenting a FamilyID
     * @param familyID domain object of the Family we want to obtain
     * @return Family domain object
     */
    public Family getByID(FamilyID familyID) {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.toString());
        Optional<FamilyJPA> familyJPA = familyRepositoryJPA.findById(familyIDJPA);
        if (familyJPA.isPresent()){
            Family family = familyAssembler.toDomain(familyJPA.get());
            return family;
        } else {
            throw new IllegalArgumentException("Family does not exists");
        }
    }

    public void verifyAdmin(PersonID loggedUserID) {
        boolean result = false;
        for (Family family : this.families) {
            if (family.isPersonTheAdmin(loggedUserID)) {
                result = true;
            }
        }
        if (!result) {
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