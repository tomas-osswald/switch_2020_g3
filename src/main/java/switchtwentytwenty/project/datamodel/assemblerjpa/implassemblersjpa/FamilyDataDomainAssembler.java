package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.AssemblerDataDomain;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IFamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;

@Component
public class FamilyDataDomainAssembler implements IFamilyDataDomainAssembler {
    /**
     * Assembler method to create a Family domain object into a FamilyJPA data object.
     * @param family domain object
     * @return FamilyJPA data object
     */
    public FamilyJPA toData(Family family) {
        FamilyID familyID = family.id();
        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.toString());

        String name = family.getName().toString();
        String registrationDate = family.getRegistrationDate().toString();

        PersonID adminID = family.getAdmin();
        PersonIDJPA adminIDJPA = new PersonIDJPA(adminID.toString());

        FamilyJPA familyJPA = new FamilyJPA(familyIDJPA, name, registrationDate, adminIDJPA);

        return familyJPA;
    }

    /**
     * Assembler method to create a FamilyJPA data object into a Family domain object.
     * @param familyJPA data object
     * @return Family domain object
     */
    @Deprecated
    public Family toDomain(FamilyJPA familyJPA) {

        FamilyID familyID = new FamilyID(familyJPA.getId().toString());

        FamilyName familyName = new FamilyName(familyJPA.getFamilyName());


        RegistrationDate registrationDate = new RegistrationDate(familyJPA.getRegistrationDate());

        PersonID personID = new PersonID(familyJPA.getAdminID().toString());
        Family family = new Family(familyID, familyName, registrationDate, personID);
        return family;
    }

    public FamilyID createFamilyID(FamilyJPA familyJPA) {
        return new FamilyID(familyJPA.getId().toString());
    }

    public FamilyName createFamilyName(FamilyJPA familyJPA) {
        return new FamilyName(familyJPA.getFamilyName());
    }

    public RegistrationDate createRegistrationDate(FamilyJPA familyJPA) {
        return new RegistrationDate(familyJPA.getRegistrationDate());
    }

    public PersonID createAdminID(FamilyJPA familyJPA) {
        return new PersonID(familyJPA.getAdminID().toString());
    }
}