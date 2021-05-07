package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;

import static org.junit.jupiter.api.Assertions.*;

class FamilyDataDomainAssemblerTest {


    FamilyDataDomainAssembler familyDataDomainAssembler = new FamilyDataDomainAssembler();

    @Test
    void toData() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);
        Family family = new Family(familyID, familyName, registrationDate, adminEmail);

        FamilyJPA expected = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        FamilyJPA result = familyDataDomainAssembler.toData(family);

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void toDomain() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        Family expected = new Family(familyID, familyName, registrationDate, adminEmail);

        Family result = familyDataDomainAssembler.toDomain(familyJPA);

        assertEquals(expected, result);
        assertNotNull(result);
    }
}