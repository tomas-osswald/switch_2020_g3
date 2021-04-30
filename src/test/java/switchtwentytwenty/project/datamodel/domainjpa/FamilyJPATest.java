package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FamilyJPATest {

    String familyName = "Simpson";
    String registrationDate = "12/12/2020";

    String adminEmail = "email@email.com";
    PersonIDJPA adminID = new PersonIDJPA(adminEmail);

    FamilyIDJPA familyID = new FamilyIDJPA(UUID.randomUUID().toString());

    @Test
    @Tag("US010")
    void getFamilyNameTest() {
        String expected = "Simpson";
        FamilyJPA familyJPA = new FamilyJPA(familyID, familyName, registrationDate, adminID);

        String result = familyJPA.getFamilyName();

        assertEquals(expected,result);
    }

    @Test
    @Tag("US010")
    void getRegistrationDateTest() {
        String expected = "12/12/2020";
        FamilyJPA familyJPA = new FamilyJPA(familyID,familyName,registrationDate,adminID);

        String result = familyJPA.getRegistrationDate();

        assertEquals(expected,result);
    }

    @Test
    @Tag("US010")
    void getAdminEmailTest() {
        String expected = "email@email.com";
        FamilyJPA familyJPA = new FamilyJPA(familyID,familyName,registrationDate,adminID);

        String result = familyJPA.getAdminID().toString();

        assertEquals(expected,result);
    }

    @Test
    @Tag("US010")
    void getFamilyIDTest() {
        String expected = familyID.toString();
        FamilyJPA familyJPA = new FamilyJPA(familyID,familyName,registrationDate,adminID);

        String result = familyJPA.getId().toString();

        assertEquals(expected,result);
    }

}