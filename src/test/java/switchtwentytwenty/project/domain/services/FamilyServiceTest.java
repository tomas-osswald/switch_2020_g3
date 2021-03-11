package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.dtos.output.FamilyWithoutAdministratorDTO;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.user_data.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    String cc = "143896040ZV3";
    CCNumber ccNumber = new CCNumber(cc);
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

    //ProfileMemberDTO setup
    Address address = new Address(rua, codPostal, local, city);
    EmailAddress emailAddress = new EmailAddress(email);
    List<EmailAddress> emails = new ArrayList<>();
    PhoneNumber phoneNumber = new PhoneNumber(numero);
    List<PhoneNumber> phoneNumbers = new ArrayList<>();
    VatNumber vatNumber = new VatNumber(nif);
    FamilyService familyService = new FamilyService();

    //Added 2nd FamilyMember to test
    String cc2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "pai";
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    String id3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1900, 8, 26);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122100;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    boolean admin3 = true;

    //Added 4th FamilyMember to test no relation attribution
    String id4 = "000000000ZZ4";
    String name4 = "TonyZe";
    Date date4 = new Date(1920, 8, 26);
    int numero4 = 919939998;
    String email4 = "tonyze@gmail.com";
    int nif4 = 212122000;
    String rua4 = "Rua";
    String codPostal4 = "4444-556";
    String local4 = "Gaia";
    String city4 = "Porto";

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember manuelAdmin = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, admin3);
    FamilyMember noRelationMember = new FamilyMember(id4, name4, date4, numero4, email4, nif4, rua4, codPostal4, local4, city4);
    int familyOneID = 123;
    String familyOneName = "Simpson";
    int familyTwoID = 456;
    String familyTwoName = "Simpson";
    int familyThreeID = 789;
    String familyThreeName = "Simpson";
    Family family = new Family(familyOneName, familyOneID);
    Family familyTwo = new Family(familyTwoName, familyTwoID);
    Family familyThree = new Family(familyThreeName, familyThreeID);
    ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    List<FamilyMemberRelationDTO> expected = new ArrayList<FamilyMemberRelationDTO>();

    int familyOneIDGenerated = 1;
    int familyTwoIDGenerated = 2;
    int familyThreeIDGenerated = 3;

    AddFamilyMemberDTO familyMemberDTO1 = new AddFamilyMemberDTO(cc,cc, name, date, numero, email, nif, rua, codPostal, local, city,1);
    AddFamilyMemberDTO familyMemberDTO12 = new AddFamilyMemberDTO(cc, cc, name, date, numero, email, nif, rua, codPostal, local, city, 2);
    AddFamilyMemberDTO familyMemberDTO13 = new AddFamilyMemberDTO(cc,cc, name, date, numero, email, nif, rua, codPostal, local, city, familyThreeIDGenerated);
    AddFamilyMemberDTO familyMemberDTO21 = new AddFamilyMemberDTO(cc,cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2,1);
    AddFamilyMemberDTO familyMemberDTO22 = new AddFamilyMemberDTO(cc,cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2,2);
    AddFamilyMemberDTO familyMemberDTO2x1 = new AddFamilyMemberDTO(cc,cc2, name2, date2, numero2, email, nif2, rua2, codPostal2, local2, city2,1);
    AddFamilyMemberDTO familyMemberDTO3 = new AddFamilyMemberDTO(cc, cc2, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, 1);
    AddFamilyMemberDTO familyMemberDTO33 = new AddFamilyMemberDTO(cc,id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, familyThreeIDGenerated);
    AddFamilyMemberDTO familyMemberDTOabc1 = new AddFamilyMemberDTO(cc,cc, name, date, numero, "abc@gmail.com", nif, rua, codPostal, local, city,1);
    AddFamilyMemberDTO familyMemberDTOabc2 = new AddFamilyMemberDTO(cc,cc2, name2, date2, numero2, "abc@gmail.com", nif2, rua2, codPostal2, local2, city2,1);

    @BeforeEach
    void setup(){


    }

    @Test
    void GetFamilyByID() {
        int familyOneID = 1;
        String familyOneName = "Simpson";
        int familyTwoID = 2;
        String familyTwoName = "Moura";
        Family family1 = new Family(familyOneName, familyOneID);
        Family family2 = new Family(familyTwoName, familyTwoID);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 2;

        int expected = 2;

        int result = familyService.getFamily(familyID).getFamilyID();

        assertEquals(expected, result);
    }


    /**
     * US101 addFamilyMember
     **/
    @Test
    void NotAddFamilyMember_EmailPresent() {

        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        System.out.println(familyMemberDTOabc2.getFamilyID());
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(familyMemberDTOabc2));
    }

    @Test
    void AddFamilyMember_EmailNotPresent() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        System.out.println(familyMemberDTO21.getFamilyID());
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(familyMemberDTO21));
    }

    @Test
    void NotAddFamilyMember_FamilyNotExists() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(familyMemberDTO22));
    }

    @Test
    void AddFamilyMember_FamilyExists() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(familyMemberDTO21));
    }

    @Test
    void NotAddFamilyMember_NotAdmin() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(familyMemberDTO21));
    }

    @Test
    void AddFamilyMember_isAdmin() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(familyMemberDTO3));
    }

    /**
     * US011 addFamilyAdministrator
     **/
    @Test
    void addFamilyAdministrator_FamilyExists() {
        Family ribeiros = new Family("Ribeiro", 1);
        FamilyService familyService = new FamilyService(ribeiros);
        assertTrue(familyService.addFamilyAdministrator(familyMemberDTO1));
    }

    @Test
    void NotAddFamilyAdministrator_FamilyNotExists() {
        Family ribeiros = new Family("Ribeiro", 1);
        FamilyService familyService = new FamilyService(ribeiros);
        assertThrows(IllegalArgumentException.class, () -> familyService.addFamilyAdministrator(familyMemberDTO12));
    }

    @Test
    void addFamilyAdministrator_EmailNotPresent() { // Not able to create a family member object
        Family ribeiros = new Family("Ribeiro", 1);
        ribeiros.addFamilyMember(familyMemberDTO1);
        FamilyService familyService = new FamilyService(ribeiros);
        assertTrue(familyService.addFamilyAdministrator(familyMemberDTO21));
    }

    @Test
    void NotAddFamilyAdministrator_EmailPresent() { // Not able to create a family member object
        Family ribeiros = new Family("Ribeiro", 1);
        ribeiros.addFamilyMember(familyMemberDTOabc1);
        FamilyService familyService = new FamilyService(ribeiros);
        assertThrows(IllegalArgumentException.class, () -> familyService.addFamilyAdministrator(familyMemberDTOabc2));
    }

    @Test
    void addFamilyAdministratorTrue() {
        FamilyService familyService = new FamilyService();
        familyService.addFamily(familyOneName); //id1

        assertTrue(familyService.addFamilyAdministrator(familyMemberDTO1));
    }

    @Test
    void addFamilyAdministratorThrowFromFamily() { // Not able to create a family member object
        FamilyService familyService = new FamilyService();
        familyService.addFamily(familyOneName); //id1

        assertThrows(Exception.class, () -> familyService.addFamilyAdministrator(familyMemberDTO12));
    }

    @Test
    void addFamilyAdministratorThrowEmailAlreadyPresent() {
        FamilyService familyService = new FamilyService();
        familyService.addFamily(familyOneName); //id1
        familyService.addFamily(familyTwoName); //id2

        familyService.addFamilyAdministrator(familyMemberDTO1); // for family One

        assertThrows(Exception.class, () -> familyService.addFamilyAdministrator(familyMemberDTO2x1)); // insert same email from user from family one
    }

    @Test
    void addFamilyAdministratorThrowFamilyDoesNotExists() {
        FamilyService familyService = new FamilyService();
        familyService.addFamily(familyOneName); //id1

        assertThrows(Exception.class, () -> familyService.addFamilyAdministrator(familyMemberDTO22)); // insert a FamilyId that doenst exists in system
    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithAdministratorExpectingTrue() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService family = new FamilyService(ribeiro);
        diogo.makeAdmin();
        boolean expected = true;
        boolean result = family.verifyAdministratorPermission(ribeiro.getFamilyID(), diogo.getCCNumberString());
        assertTrue(result);
    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithNoAdministratorExpectingFalse() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService family = new FamilyService(ribeiro);
        boolean expected = false;
        boolean result = family.verifyAdministratorPermission(ribeiro.getFamilyID(), "000000000ZZ4");
        assertFalse(result);
    }


    @Test
    void getDTOList_TestExceptionThrowNoFamilyWithGivenID() {
        //Arrange
        FamilyService familyService = new FamilyService(family);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> familyService.getFamilyMembersRelationDTOList(8898, manuelAdmin.getCCNumberString()));
    }


    @Test
    void getFamilyMemberProfileUsingIDsTest1_MemberProfileDTOIsEquals() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        familyService.addFamily(family);
        family.addFamilyMember(diogo);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = familyService.getFamilyMemberProfile(familyOneID, diogo.getCCNumberString());

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getFamilyMemberProfileUsingIDsTest2_MemberProfileDTOIsNotEquals() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        familyService.addFamily(family);
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = familyService.getFamilyMemberProfile(familyOneID, jorge.getCCNumberString());

        assertNotEquals(expected, result);
    }


    @Test
    void listOfFamiliesWithoutFamilyAdministratorWithNoFamilies_NoFamilyHaveBeenAdded() {
        FamilyService familyService = new FamilyService();

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>(); //empty list

        List<FamilyWithoutAdministratorDTO> result = familyService.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void listOfFamiliesWithoutFamilyAdministrator_WithFamilies_WithAndWithoutAdministrator() {
        FamilyService familyService = new FamilyService();

        familyService.addFamily(familyOneName); //id1
        familyService.addFamily(familyTwoName); //id2
        familyService.addFamily(familyThreeName); //id3

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>();
        FamilyWithoutAdministratorDTO dto1 = familyService.getFamily(familyOneIDGenerated).familyWithoutAdministratorDTO();
        FamilyWithoutAdministratorDTO dto2 = familyService.getFamily(familyTwoIDGenerated).familyWithoutAdministratorDTO();
        FamilyWithoutAdministratorDTO dto3 = familyService.getFamily(familyThreeIDGenerated).familyWithoutAdministratorDTO();
        expected.add(dto1);
        expected.add(dto2);
        expected.add(dto3);

        List<FamilyWithoutAdministratorDTO> result = familyService.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void listOfFamiliesWithoutFamilyAdministrator_AllFamiliesHaveAdministrator() {

        FamilyService familyService = new FamilyService();

        familyService.addFamily(familyOneName); //id1
        familyService.addFamily(familyTwoName); //id2
        familyService.addFamily(familyThreeName); //id3

        familyService.addFamilyAdministrator(familyMemberDTO1);
        familyService.addFamilyAdministrator(familyMemberDTO22);
        familyService.addFamilyAdministrator(familyMemberDTO33);

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>(); //empty list

        List<FamilyWithoutAdministratorDTO> result = familyService.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void listOfFamiliesWithoutFamilyAdministrator_WithNoFamilies_AllFamiliesHaveAdministrator() {
        FamilyService familyService = new FamilyService();

        familyService.addFamily(familyOneName);
        familyService.addFamily(familyTwoName);

        assertThrows(Exception.class, () -> familyService.addFamilyAdministrator(familyMemberDTO13));
    }

    @Test
    void addFamily_Test1NameMoreiraSuccess() {
        FamilyService familyService = new FamilyService();
        String familyName = "Moreira";

        boolean result = familyService.addFamily(familyName);

        Assertions.assertTrue(result);
    }

    @Test
    void addFamily_Test2NameSimpsonSuccess() {
        FamilyService familyService = new FamilyService();
        String familyName = "Simpson";

        boolean result = familyService.addFamily(familyName);

        Assertions.assertTrue(result);
    }

    @Test
    void addFamily_Test3Failure() {
        FamilyService familyService = new FamilyService();
        String familyName = "";

        boolean result = familyService.addFamily(familyName);

        Assertions.assertFalse(result);
    }

    @Test
    void getFamilyListLenght() {
        FamilyService familyService = new FamilyService();
        String familyNameOne = "Moreira";
        familyService.addFamily(familyNameOne);
        String familyNameTwo = "Silva";
        familyService.addFamily(familyNameTwo);
        String familyNameThree = "Seisdedos";
        familyService.addFamily(familyNameThree);
        int expected = 3;

        int result = familyService.getFamilyListLenght();

        Assertions.assertEquals(expected,result);
    }
}