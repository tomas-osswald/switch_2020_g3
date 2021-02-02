package switchtwentytwenty.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.user_data.*;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    String cc = "135149126ZW9";
    CCNumber ccNumber = new CCNumber(cc);
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
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
    String relacao2 = "primo";

    AddFamilyMemberDTO familyMemberDTO1 = new AddFamilyMemberDTO(cc,cc, name, date, numero, email, nif, rua, codPostal, local, city,1);
    AddFamilyMemberDTO familyMemberDTO2 = new AddFamilyMemberDTO(cc,cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2,1);
    AddFamilyMemberDTO familyMemberDTO3 = new AddFamilyMemberDTO(cc,cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2,1);


    boolean admin2 = false;


    //Setup for getFamilyMemberRelationDTO List
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    FamilyMember jorge = new FamilyMember(cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2);
    FamilyMember newMember = new FamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2);
    List<FamilyMemberRelationDTO> expectedDTOList = new ArrayList<>();
    ArrayList<FamilyMember> expectedFamilyMembers = new ArrayList<>();
    Relation relation2 = new Relation(relacao2, diogo, jorge, false);
    Relation relation = new Relation(relacao, jorge, diogo, false);

    int familyOneID = 123;
    String familyOneName = "Simpson";
    Family family = new Family(familyOneName, familyOneID);


    @Test
    void AddFamilyMembers() {
        FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        FamilyMember familyMember2 = new FamilyMember(cc2, name2, date2, numero, email2, nif2, rua2, codPostal2, local2, city2);

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void AddFamilyMembersArray() {
        FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        FamilyMember familyMember2 = new FamilyMember(cc2, name2, date2, numero, email2, nif2, rua2, codPostal2, local2, city2);

        ArrayList<FamilyMember> familyMembersList = new ArrayList<>();

        familyMembersList.add(familyMember1);
        familyMembersList.add(familyMember2);

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMemberArray(familyMembersList);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void IsAdminTrue() {

        FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);

        assertTrue(family.verifyAdministrator(cc));
    }

    @Test
    void IsAdminFalse() {
        FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);

        assertFalse(family.verifyAdministrator(cc));
    }

    @Test
    void AdminWithGivenIDNotFoundNoFamilyMemberWithThatID() {
        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "137476450ZX0";
        FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        FamilyMember familyMember2 = new FamilyMember(cc2, name2, date2, numero, email2, nif2, rua2, codPostal2, local2, city2);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        String notAtribuitedID = "137843828ZX3";

        assertFalse(family.verifyAdministrator(notAtribuitedID));
    }


    @Test
    void familyConstructorTest1_validNameSimpson() {
        String familyName = "Simpson";
        int familyID = 1;
        Family newFamily = new Family(familyName, familyID);

        assertNotNull(newFamily);
    }

    @Test
    void familyConstructorTest2_validNameMoura() {
        String familyName = "Moura";
        int familyID = 1;
        Family newFamily = new Family(familyName, familyID);

        assertNotNull(newFamily);
    }

    @Test
    void familyConstructorTest3_validNameAndLargeID() {
        String familyName = "Moura";
        int familyID = 200;
        Family newFamily = new Family(familyName, familyID);

        assertNotNull(newFamily);
    }

    @Test
    void familyConstructorTest4_invalidNameNull() {
        String familyName = null;
        int familyID = 1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Family newFamily = new Family(familyName, familyID);
        });
    }

    @Test
    void familyConstructorTest5_invalidNameEmpty() {
        String familyName = "";
        int familyID = 1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Family newFamily = new Family(familyName, familyID);
        });
    }

    @Test
    void familyConstructorTest6_invalidNameBlank() {
        String familyName = "    ";
        int familyID = 1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Family newFamily = new Family(familyName, familyID);
        });
    }

    @Test
    void AddFamilyMember_VatNotExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyMember(familyMemberDTO2));
    }

    @Test
    void NotAddFamilyMember_VatExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(familyMemberDTO3));
    }

    @Test
    void AddFamilyMember_CCNotExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyMember(familyMemberDTO2));
    }

    @Test
    void NotAddFamilyMember_CCExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(familyMemberDTO3));
    }

    @Test
    void AddFamilyMember_() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "", date, numero, email, nif, rua, codPostal, local, city, admin));
    }

    @Test
    void familyHasAdministrator() {
        Family family = new Family(familyOneName, familyOneID);
        family.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        family.addFamilyMember(familyMemberDTO2);

        assertTrue(family.hasAdministrator());
    }

    @Test
    void familyHasNoAdministratorWithFamilyMembers() {
        Family family = new Family(familyOneName, familyOneID);
        family.addFamilyMember(familyMemberDTO1);

        assertFalse(family.hasAdministrator());
    }

    @Test
    void familyHasNoAministratorWithNoFamilyMembers() {
        Family family = new Family(familyOneName, familyOneID);

        assertFalse(family.hasAdministrator());
    }

    @Test
    void addFamilyAdministrator_VatNotExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyAdministrator(cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2));
    }

    @Test
    void NotAddFamilyAdministrator_VatExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, () -> familia.addFamilyAdministrator(cc2, name2, date2, numero2, email2, nif, rua2, codPostal2, local2, city2));
    }

    @Test
    void addFamilyAdministrator_CCNotExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyMember(familyMemberDTO2));
    }

    @Test
    void NotAddFamilyAdministrator_CCExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(familyMemberDTO3));
    }


    @Test
    void getFamilyMemberProfileUsingIDsTest1_MemberProfileDTOIsEquals() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        familyService.addFamily(family);
        family.addFamilyMember(diogo);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber,name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = family.getFamilyMemberProfile(diogo.getID());

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getFamilyMemberProfileUsingIDsTest2_MemberProfileDTOIsNotEquals() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = family.getFamilyMemberProfile(jorge.getID());

        assertNotEquals(expected, result);
    }

    /**
     * Test to verify if an empty Family (i.e. with no Family Members) returns an empty List
     * of FamilyMemberRelationDTO
     */
    @Test
    void getFamilyMembersRelationDTOList_FamilyWithNoMembersReturningEmptyList() {
        List<FamilyMemberRelationDTO> expected = expectedDTOList;
        List<FamilyMemberRelationDTO> result = family.getFamilyMembersRelationDTOList();
        assertEquals(expectedDTOList, result);
        assertNotSame(expectedDTOList, result);
    }

    @Test
    void hasDesignationInRelationDesignationList() {
        Family family = new Family(familyOneName, familyOneID);

        String relationDesignation1 = "Mother";
        family.addToRelationDesignationList(relationDesignation1);

        String relationDesignation2 = "Mother";

        assertTrue(family.hasDesignation(relationDesignation2));
    }

    @Test
    void hasDesignationInRelationDesignationListNotInList() {
        Family family = new Family(familyOneName, familyOneID);

        String relationDesignation1 = "Mother";
        family.addToRelationDesignationList(relationDesignation1);

        String relationDesignation2 = "COUSIN";

        assertFalse(family.hasDesignation(relationDesignation2));
    }

    @Test
    void testHashCode_Test1True() {
        Family familyOne = new Family(familyOneName, familyOneID);
        Family familyTwo = new Family(familyOneName, familyOneID);

        Assertions.assertEquals(familyOne.hashCode(),familyTwo.hashCode());
    }

    @Test
    void testHashCode_Test2False() {
        Family familyOne = new Family(familyOneName, familyOneID);
        String familyTwoName = "Griffin";
        int familyTwoID = 321;
        Family familyTwo = new Family(familyTwoName, familyTwoID);

        Assertions.assertNotEquals(familyOne.hashCode(),familyTwo.hashCode());
    }

    @Test
    void testEquals_notAFamily(){
        Family familyOne = new Family(familyOneName, familyOneID);
        Date notAFamily = new Date();

        Assertions.assertNotEquals(familyOne,notAFamily);
    }

    @Test
    void testEquals_familiesAreEquals(){
        Family familyOne = new Family(familyOneName, familyOneID);
        Family familyTwo = new Family(familyOneName, familyOneID);

        Assertions.assertEquals(familyOne,familyTwo);
    }


    @Test
    void getCustomCategoryByID() {
        int customCategoryID = -1;
        CustomCategory customCategory = new CustomCategory("TestCategory",customCategoryID);
        family.addCategory(customCategory);

        CustomCategory result = family.getCustomCategoryByID(customCategoryID);


        Assertions.assertEquals(customCategory,result);
    }

    @Test
    void getCustomCategoryByID_IDoutOfBounds() {
        int customCategoryID = -1;
        CustomCategory customCategory = new CustomCategory("TestCategory",customCategoryID);
        family.addCategory(customCategory);

        CustomCategory result = family.getCustomCategoryByID(-100);


        Assertions.assertNull(result);
    }

}