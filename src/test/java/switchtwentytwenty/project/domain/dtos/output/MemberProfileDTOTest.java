package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.user_data.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberProfileDTOTest {

    //Family Member Diogo
    String cc = "000000000ZZ4";
    CCNumber ccNumber = new CCNumber(cc);
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";

    boolean admin = false;

    //Setup for MemberProfileDTO testing
    Address address = new Address(rua, codPostal, local, city);

    EmailAddress emailAddress = new EmailAddress(email);
    List<EmailAddress> emails = new ArrayList<>();

    PhoneNumber phoneNumber = new PhoneNumber(numero);
    List<PhoneNumber> phoneNumbers = new ArrayList<>();

    VatNumber vatNumber = new VatNumber(nif);


    //Family Member Tony
    String id2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";

    boolean admin2 = false;

    //Setup for FamilyMemberDTO

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember diogoNoAdmin = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    FamilyMember newMember = new FamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2);
    Relation relation2 = new Relation(relacao2, diogo, jorge, false);
    Relation relation = new Relation(relacao, jorge, diogo, false);



    @Test
    void getMemberProfileTest1_objectsAreEqual() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        CCNumber differentCCNumber = new CCNumber("166699209ZY8");
        MemberProfileDTO dto1 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertEquals(dto1, dto2);
        assertNotSame(dto1, dto2);
    }

    @Test
    void getMemberProfileTest2_objectsAreNotEqualCCNumber() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        CCNumber differentCCNumber = new CCNumber("166699209ZY8");

        MemberProfileDTO dto1 = new MemberProfileDTO(differentCCNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);
        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(dto1, dto2);
    }

    //compares diogo, but creates MemberProfileDTO from jorge
    @Test
    void getMemberProfileTest3_objectsAreNotEqualName() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        MemberProfileDTO dto1 = new MemberProfileDTO(ccNumber, "Passaro Maluco", date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(dto1, dto2);
    }
    @Test
    void getMemberProfileTest4_objectsAreNotEqualDate() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        Date differentDate = new Date(2021, 01, 01);
        MemberProfileDTO dto1 = new MemberProfileDTO(ccNumber, name, differentDate, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(dto1, dto2);
    }
    @Test
    void getMemberProfileTest5_objectsAreNotEqualVATNumber() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        VatNumber differentVatNumber = new VatNumber(nif2);
        MemberProfileDTO dto1 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, differentVatNumber, address, admin);

        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(dto1, dto2);
    }
    @Test
    void getMemberProfileTest6_objectsAreNotEqualAddress() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        Address differentAddress = new Address("Rua of the night", "4200-054", "The biceps", "Malucos");
        MemberProfileDTO dto1 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, differentAddress, admin);

        MemberProfileDTO dto2 = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(dto1, dto2);
    }
}