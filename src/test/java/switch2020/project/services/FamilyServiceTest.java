package switch2020.project.services;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    String cc = "000000000ZZ4";
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
    String cc2 = "000000000ZZ4";
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
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    String id3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1900, 8, 26);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";
    Relation relation3 = new Relation(relacao3);
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
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, admin);
    FamilyMember jorge = new FamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, admin2);
    FamilyMember manuelAdmin = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, relation3, admin3);
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
    FamilyMemberRelationDTO diogoDTO = new FamilyMemberRelationDTO(diogo.getName(), diogo.getRelation());
    FamilyMemberRelationDTO jorgeDTO = new FamilyMemberRelationDTO(jorge.getName(), jorge.getRelation());
    FamilyMemberRelationDTO manuelAdminDTO = new FamilyMemberRelationDTO(manuelAdmin.getName(), manuelAdmin.getRelation());
    List<FamilyMemberRelationDTO> expected = new ArrayList<FamilyMemberRelationDTO>();

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

    @Test
    void GivenFamilyIDNotFound() {
        int familyOneID = 1;
        String familyOneName = "Simpson";
        int familyTwoID = 2;
        String familyTwoName = "Moura";
        String selfID = "000000000ZZ4";
        String otherID = "000000000ZZ4";
        Family family1 = new Family(familyOneName, familyOneID);
        Family family2 = new Family(familyTwoName, familyTwoID);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 3; //Dont exist any family with that ID number

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(selfID, otherID, "prima", familyID));
    }

    @Test
    void CreateRelation() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Simpson";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertTrue(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void NotAdminTryingToCreateRelationReturningFalse() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        String familyName = "Simpson";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertFalse(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void FamilyDontExist() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Simpson";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        int familyID2 = 2;

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID2));
    }

    @Test
    void CreateAnExistingRelationDesignation() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "mother";
        FamilyService familyService = new FamilyService();

        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "137843828ZX3";
        String familyMemeberID3 = "137476450ZX0";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        FamilyMember familyMember3 = new FamilyMember(familyMemeberID3);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Simpson";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);
        family.addFamilyMember(familyMember3);

        int expected = 1;

        familyService.addFamily(family);

        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        int result = family.numberOfRelationDesignations();

        assertTrue(familyService.createRelation(familyMemberID1, familyMemeberID3, relationDesignation2, familyID));
        assertEquals(expected, result);
    }

    @Test
    void FamilyMemberWithARelationAssigned() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "Father";
        FamilyService familyService = new FamilyService();
        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();
        int familyID = 1;
        String familyName = "Simpson";
        Family family = new Family(familyName, familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);
        familyService.addFamily(family);
        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);
        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation2, familyID));
    }

    @Test
    void createFamilyCashAccountResultFalseAccountAlreadyExists() {
        FamilyService familyService = new FamilyService();
        int familyID = 1;
        String familyName = "Simpson";
        Family aFamily = new Family(familyName, familyID);
        familyService.addFamily(aFamily);
        boolean expected = true;
        double balance = 0;

        boolean result = familyService.createFamilyCashAccount(familyID, balance);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountResultTrueAccountCreated() {
        FamilyService familyService = new FamilyService();
        int familyID = 1;
        String familyName = "Simpson";
        Family aFamily = new Family(familyName, familyID);
        double balance = 0;
        familyService.addFamily(aFamily);
        familyService.createFamilyCashAccount(familyID, balance);
        boolean expected = false;

        boolean result = familyService.createFamilyCashAccount(familyID, balance);

        assertEquals(expected, result);
    }

    @Test
    void NotAddFamilyMember_EmailPresent() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc, name2, date2, numero2, "abc@gmail.com", nif2, rua2, codPostal2, local2, city2, relation2, 1));
    }

    @Test
    void AddFamilyMember_EmailNotPresent() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(cc, cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, 1));
    }

    @Test
    void NotAddFamilyMember_FamilyNotExists() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, 2));

    }

    @Test
    void AddFamilyMember_FamilyExists() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(cc, cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, 1));
    }

    @Test
    void NotAddFamilyMember_NotAdmin() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, false);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, 1));
    }

    @Test
    void AddFamilyMember_isAdmin() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, true);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService familias = new FamilyService(ribeiro);
        assertTrue(familias.addFamilyMember(cc, cc, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, relation3, 1));
    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithAdministratorExpectingTrue() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, admin);
        int familyID = 1;
        String familyName = "Ribeiro";
        Family ribeiro = new Family(familyName, familyID);
        ribeiro.addFamilyMember(diogo);
        FamilyService family = new FamilyService(ribeiro);
        diogo.makeAdmin();
        boolean expected = true;
        boolean result = family.verifyAdministratorPermission(ribeiro.getFamilyID(), diogo.getID());
        assertTrue(result);
    }

    //Test related to validation before obtaining FamilyMemberRelationDTOList
    @Test
    void verifyAdministratorPermissionBeforeInvokingGetDTOList_TestWithNoAdministratorExpectingFalse() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, admin);
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
    void getDTOList_ExpectingToHaveEqualListsBecauseMemberIsAdminAndMethodWillReturnFilledList() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        expected.add(diogoDTO);
        expected.add(jorgeDTO);
        expected.add(manuelAdminDTO);
        FamilyService familyService = new FamilyService(family);
        //Act
        List<FamilyMemberRelationDTO> result = familyService.getFamilyMembersRelationDTOList(family.getFamilyID(), manuelAdmin.getID());
        //Assert
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getDTOList_TestWithNoAdministratorIDExpectingToBeNotEqualsBecauseTheFamilyMemberIsNotAdministratorAndTheReturnIsEmptyList() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        expected.add(diogoDTO);
        expected.add(jorgeDTO);
        expected.add(manuelAdminDTO);
        FamilyService familyService = new FamilyService(family);
        //Act
        List<FamilyMemberRelationDTO> result = familyService.getFamilyMembersRelationDTOList(family.getFamilyID(), jorge.getID());
        //Assert
        assertNotEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getDTOList_TestWithFamilyMemberWithNoRelationPreviouslyAttributedExpectingDTOToConvertToRelationNotDefined() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(noRelationMember);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        expected.add(diogoDTO);
        expected.add(jorgeDTO);
        expected.add(manuelAdminDTO);
        FamilyService familyService = new FamilyService(family);
        //Act
        List<FamilyMemberRelationDTO> result = familyService.getFamilyMembersRelationDTOList(family.getFamilyID(), noRelationMember.getID());
        //Assert
        assertNotEquals(expected, result);
        assertNotSame(expected, result);
    }


}