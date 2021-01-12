package switch2020.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    String cc = "000000000ZZ4";
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
    Relation relation = new Relation(relacao);
    boolean admin = false;

    String cc2 = "000000000ZZ3";
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

    @Test
    void AddFamilyMembers() {
        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

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
        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "000000000ZZ4";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

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
        String familyMemberID = "000000000ZZ4";

        FamilyMember familyMember1 = new FamilyMember(familyMemberID);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);

        assertTrue(family.isAdmin(familyMemberID));
    }

    @Test
    void IsAdminFalse() {
        String familyMemberID = "000000000ZZ4";

        FamilyMember familyMember1 = new FamilyMember(familyMemberID);

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);

        assertFalse(family.isAdmin(familyMemberID));
    }

    @Test
    void AdminWithGivenIDNotFoundNoFamilyMemberWithThatID() {
        String familyMemberID1 = "000000000ZZ4";
        String familyMemberID2 = "137476450ZX0";
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        String notAtribuitedID = "137843828ZX3";

        assertFalse(family.isAdmin(notAtribuitedID));
    }

    @Test
    void FamilyMemberWithGivenIDDoesntExist() {
        String familyMemberID = "000000000ZZ4";
        String familyMemberIDThatDoesntExist = "000000020ZZ4";
        FamilyMember familyMember = new FamilyMember(familyMemberID);

        int familyID = 1;
        String familyName = "Moreira";
        Family family = new Family(familyName, familyID);
        family.addFamilyMember(familyMember);

        String relationDesignation = "Mother";
        Relation relation = new Relation(relationDesignation);

        assertThrows(IllegalArgumentException.class, () -> family.addRelationToFamilyMember(familyMemberIDThatDoesntExist, relation));
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
    void createFamilyCashAccountResultFalseAccountAlreadyExists() {
        String familyName = "Simpson";
        int familyID = 1;
        double balance = 0;
        Family familyOne = new Family(familyName, familyID);
        familyOne.createFamilyCashAccount(balance);
        boolean expected = false;

        boolean result = familyOne.createFamilyCashAccount(balance);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountResultTrueAccountCreated() {
        String familyName = "Simpson";
        int familyID = 1;
        double balance = 0;
        Family familyOne = new Family(familyName, familyID);
        boolean expected = true;

        boolean result = familyOne.createFamilyCashAccount(balance);

        assertEquals(expected, result);
    }

    @Test
    void AddFamilyMember_VatNotExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, admin);
        FamilyMember pessoa2 = pessoa1;
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2));
    }

    @Test
    void NotAddFamilyMember_VatExists() {
        FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation, admin);
        FamilyMember pessoa2 = pessoa1;
        String familyName = "Moreira";
        int familyID = 1;
        Family familia = new Family(familyName, familyID);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, relation));
    }

    @Test
    void AddFamilyMember_() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "", date, numero, email, nif, rua, codPostal, local, city, relation, admin));
    }

    /*@Test
    void familyHasAdministrator() {
        Family family = new Family();
        family.addFamilyAdministrator();
        family.addFamilyMember();

        assertTrue(family.hasAdministrator());
    }

    @Test
    void familyHasNoAdministratorWithFamilyMembers() {
        Family family = new Family();
        family.addFamilyMember();

        assertFalse(family.hasAdministrator());
    }

    @Test
    void familyHasNoAministratorWithNoFamilyMembers() {
        Family family = new Family();

        assertFalse(family.hasAdministrator());
    }*/
}