package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Test to assert that the FamilyID is successfully created")
    void createFamilyID() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        FamilyID expected = new FamilyID("admin@gmail.com");
        FamilyID result = familyDataDomainAssembler.createFamilyID(familyJPA);

        assertNotNull(result);
        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to assert that the FamilyName is successfully created")
    void createFamilyName() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        FamilyName expected = new FamilyName(familyNameString);
        FamilyName result = familyDataDomainAssembler.createFamilyName(familyJPA);

        assertNotNull(result);
        assertNotSame(expected, result);
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Test to assert that the RegistrationDate is successfully created")
    void createRegistrationDate() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        RegistrationDate expected = new RegistrationDate(date);
        RegistrationDate result = familyDataDomainAssembler.createRegistrationDate(familyJPA);

        assertNotNull(result);
        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createAdminID() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA(familyID.toString()), familyName.toString(), registrationDate.toString(), new PersonIDJPA(adminEmail.toString()));

        PersonID expected = new PersonID(emailString);
        PersonID result = familyDataDomainAssembler.createAdminID(familyJPA);

        assertNotNull(result);
        assertNotSame(expected, result);
        assertEquals(expected, result);
    }
}