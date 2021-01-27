package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.*;
import switch2020.project.domain.DTOs.output.MemberProfileDTO;
import switch2020.project.domain.model.user_data.Address;
import switch2020.project.domain.model.user_data.EmailAddress;
import switch2020.project.domain.model.user_data.PhoneNumber;
import switch2020.project.domain.model.user_data.VatNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetFamilyMemberProfileControllerTest {

    //Added 1st FamilyMember to test
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

    boolean admin = false;

    Application app = new Application();
    GetFamilyMemberProfileController controller = new GetFamilyMemberProfileController(app);
    Address address = new Address(rua, codPostal, local, city);
    EmailAddress emailAddress = new EmailAddress(email);
    List<EmailAddress> emails = new ArrayList<>();
    PhoneNumber phoneNumber = new PhoneNumber(numero);
    List<PhoneNumber> phoneNumbers = new ArrayList<>();
    VatNumber vatNumber = new VatNumber(nif);

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
    boolean admin2 = false;


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
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        app.getFamilyService().addFamily(family);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(diogo);
        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = controller.getMemberProfile(familyOneID, diogo.getID());

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void getFamilyMemberProfileUsingIDsTest2_MemberProfileDTOIsNotEqual() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        app.getFamilyService().addFamily(family);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(diogo);
        app.getFamilyService().getFamily(familyOneID).addFamilyMember(jorge);

        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = controller.getMemberProfile(familyOneID, jorge.getID());

        assertNotEquals(expected, result);
    }
    
}