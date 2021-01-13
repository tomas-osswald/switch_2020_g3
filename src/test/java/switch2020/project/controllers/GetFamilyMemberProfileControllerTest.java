package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.*;
import switch2020.project.utils.FamilyMemberRelationDTO;
import switch2020.project.utils.MemberProfileDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetFamilyMemberProfileControllerTest {

    String id = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = false;

    //Added 2nd FamilyMember to test
    String id2 = "137476450ZX0";
    String name2 = "Tony";
    Date date2 = new Date(1954,8,26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    //Added 3nd FamilyMember to test (no email)
    String id3 = "137476450ZX0";
    String name3 = "Tony";
    Date date3 = new Date(1954,8,26);
    int numero3 = 919999998;
    String email3 = "tony@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";
    Relation relation3 = new Relation(relacao2);
    boolean admin3 = false;


    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id, name, date,numero,email,nif,rua,codPostal,local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    int familyOneID = 123;
    String familyOneName = "Simpson";
    Family family = new Family(familyOneName,familyOneID);

    @Test
    void instantiationOfGetFamilyMemberProfileControllerTest() {
        Application app = new Application();

        GetFamilyMemberProfileController controller = new GetFamilyMemberProfileController(app);

        assertNotNull(controller);
    }
    @Test
    void getFamilyMemberProfileUsingIDsTest1_MemberProfileDTOIsEqual() {
        //Arrange
        Application app = new Application();
        GetFamilyMemberProfileController controller = new GetFamilyMemberProfileController(app);

        Address address = new Address(rua, codPostal, local, city);

        EmailAddress emailAddress = new EmailAddress(email);
        List<EmailAddress> emails = new ArrayList<>();
        emails.add(emailAddress);

        PhoneNumber phoneNumber = new PhoneNumber(numero);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);

        VatNumber vatNumber = new VatNumber(nif);

        app.getFamilyService().addFamily(family);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(diogo);

        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, relation, admin);
        //Act
        MemberProfileDTO result = controller.getMemberProfile(familyOneID, diogo.getID());
        //Assert
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void getFamilyMemberProfileUsingIDsTest2_MemberProfileDTOIsNotEqual() {
        //Arrange
        Application app = new Application();
        GetFamilyMemberProfileController controller = new GetFamilyMemberProfileController(app);

        Address address = new Address(rua, codPostal, local, city);

        EmailAddress emailAddress = new EmailAddress(email);
        List<EmailAddress> emails = new ArrayList<>();
        emails.add(emailAddress);

        PhoneNumber phoneNumber = new PhoneNumber(numero);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);

        VatNumber vatNumber = new VatNumber(nif);

        app.getFamilyService().addFamily(family);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(diogo);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(jorge);

        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, relation, admin);
        //Act
        MemberProfileDTO result = controller.getMemberProfile(familyOneID, jorge.getID());
        //Assert
        assertNotEquals(expected, result);
    }
    
}