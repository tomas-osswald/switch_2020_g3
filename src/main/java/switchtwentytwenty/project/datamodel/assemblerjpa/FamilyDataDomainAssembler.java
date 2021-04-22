package switchtwentytwenty.project.datamodel.assemblerjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FamilyDataDomainAssembler {

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

    public Family toDomain(FamilyJPA familyJPA) {

        FamilyID familyID = new FamilyID(familyJPA.getId().toString());

        FamilyName familyName = new FamilyName(familyJPA.getFamilyName());


        RegistrationDate registrationDate = new RegistrationDate(familyJPA.getRegistrationDate());

        PersonID personID = new PersonID(familyJPA.getAdminID().toString());
        Family family = new Family(familyID, familyName, registrationDate, personID);
        return family;

    }
}
