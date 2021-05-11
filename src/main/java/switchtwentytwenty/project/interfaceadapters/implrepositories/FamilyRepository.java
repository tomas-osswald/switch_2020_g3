package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

import java.util.Optional;

@Repository
public class FamilyRepository implements IFamilyRepository {

    private IFamilyRepositoryJPA familyRepositoryJPA;

    private FamilyDataDomainAssembler familyAssembler;

    //private final Families families = new Families();
    @Autowired
    public FamilyRepository(IFamilyRepositoryJPA iFamilyRepositoryJPA, FamilyDataDomainAssembler familyDataDomainAssembler) {
        this.familyRepositoryJPA = iFamilyRepositoryJPA;
        this.familyAssembler = familyDataDomainAssembler;
    }


    /**
     * Method to add a Family domain object to the repository.
     * The Family domain object will be converted into a FamilyJPA data object and saved in the repository.
     *
     * @param family domain object we want to add to the family repository
     * @return
     */
    @Override
    public Family add(Family family) {
        FamilyJPA registeredFamilyJPA;
        Family registeredFamily;
        FamilyJPA familyJPA = familyAssembler.toData(family);
        registeredFamilyJPA = familyRepositoryJPA.save(familyJPA);
        registeredFamily = familyAssembler.toDomain(registeredFamilyJPA);
        return registeredFamily;
    }

    /**
     * Method to check if there is already a Family in the database with a specific FamilyID. Used to ensure
     * that the familyID is unique, despite being randomly generated.
     *
     * @param familyID domain object that we want to check the existence of
     * @return true if the FamilyID is already associated with a family.
     */
    private boolean checkIfIDExists(FamilyID familyID) {
        boolean result = false;
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.toString());
        Optional<FamilyJPA> familyJPA = familyRepositoryJPA.findById(familyIDJPA);
        result = familyJPA.isPresent();
        return result;
    }


    /**
     * Method to retrieve a Family domain object by presenting a FamilyID
     *
     * @param familyID domain object of the Family we want to obtain
     * @return Family domain object
     */
    public Family getByID(FamilyID familyID) {
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.toString());
        Optional<FamilyJPA> familyJPA = familyRepositoryJPA.findById(familyIDJPA);
        if (familyJPA.isPresent()) {
            Family family = familyAssembler.toDomain(familyJPA.get());
            return family;
        } else {
            throw new IllegalArgumentException("Family does not exists");
        }
    }


}