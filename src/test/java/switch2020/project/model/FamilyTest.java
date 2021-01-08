package switch2020.project.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    int id = 1111;
    String name = "Diogo";
    String date = "26/08/1990";
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = false;

    int id2 = 2222;
    String name2 = "Tony";
    String date2 = "26/08/1954";
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
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void AddFamilyMembersArray() {
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        ArrayList<FamilyMember> familyMembersList = new ArrayList<>();

        familyMembersList.add(familyMember1);
        familyMembersList.add(familyMember2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMemberArray(familyMembersList);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void IsAdminTrue() {
        int familyMemberID = 1;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);

        assertTrue(family.isAdmin(familyMemberID));
    }

    @Test
    void IsAdminFalse() {
        int familyMemberID = 1;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);

        assertFalse(family.isAdmin(familyMemberID));
    }

    @Test
    void AdminWithGivenIDNotFoundNoFamilyMemberWithThatID() {
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        int notAtribuitedID = 3;

        assertFalse(family.isAdmin(notAtribuitedID));
    }

    @Test
    void FamilyMemberWithGivenIDDoesntExist() {
        int familyMemberID = 1;
        int familyMemberIDThatDoesntExist = 2;
        FamilyMember familyMember = new FamilyMember(familyMemberID);

        int familyID = 1;
        Family family = new Family(familyID);
        family.addFamilyMember(familyMember);

        String relationDesignation = "Mother";
        Relation relation = new Relation(relationDesignation);

        assertThrows(IllegalArgumentException.class, () -> family.addRelationToFamilyMember(familyMemberIDThatDoesntExist, relation));
    }

    @Test
    public void testGetFamilyMembers() {
        /*
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Family Batista = new Family(200489, osBatistas);
        Relation filho = new Relation("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        Batista.getMembers();

         */
    }

    @Test
    void familyConstructorTest1_validNameSimpson(){
        String familyName = "Simpson";
        Family newFamily = new Family(familyName);

        assertNotNull(newFamily);
    }

    @Test
    void familyConstructorTest2_validNameMoura(){
        String familyName = "Moura";
        Family newFamily = new Family(familyName);

        assertNotNull(newFamily);
    }

    @Test
    void createFamilyCashAccountResultFalseAccountAlreadyExists() {
        int familyID = 1;
        Family familyOne = new Family(familyID);
        familyOne.createFamilyCashAccount();
        boolean expected = false;

        boolean result = familyOne.createFamilyCashAccount();

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountResultTrueAccountCreated() {
        int familyID = 1;
        Family familyOne = new Family(familyID);
        boolean expected = true;

        boolean result = familyOne.createFamilyCashAccount();

        assertEquals(expected, result);
    }

    @Test
    void addFamilyMember_VatNotExists() {
        FamilyMember pessoa1 = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local,city,relation,admin);
        FamilyMember pessoa2 = pessoa1;
        Family familia = new Family(1);
        familia.addFamilyMember(pessoa1);
        assertTrue(familia.addFamilyMember(name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,relation2));
    }

    @Test
    void NotAddFamilyMember_VatExists() {
        FamilyMember pessoa1 = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local,city,relation,admin);
        FamilyMember pessoa2 = pessoa1;
        Family familia = new Family(1);
        familia.addFamilyMember(pessoa1);
        assertThrows(IllegalArgumentException.class, ()-> familia.addFamilyMember(name,date,numero,email,nif,rua,codPostal,local,city,relation));
    }

}