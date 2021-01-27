package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.DTOs.output.FamilyMemberRelationDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class GetFamilyMembersListControllerTest {

    String id = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 12);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    boolean admin = false;

    //Added 2nd FamilyMember to test
    String id2 = "137843828ZX3";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 12);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    String id3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1955, 8, 1);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";

    boolean admin3 = true;

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember manuelAdmin = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, admin3);
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


    @Test
    void getDTOList_TestWithWrongFamilyIDExpectingFalse() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        Application app = new Application();
        app.getFamilyService().addFamily(family);
        GetFamilyMembersListController controller = new GetFamilyMembersListController(app);
        //Act
        boolean result = controller.getFamilyMembersAndRelation(3, diogo.getID());
        //Assert
        //As nothing has been added to expected both lists are Empty, as predicted
        assertFalse(result);
    }

    @Test
    void getDTOList_TestWithNoAdministratorExpectingFalse() {
        //Arrange
        familyMembers.add(diogo);
        familyMembers.add(jorge);
        familyMembers.add(manuelAdmin);
        family.addFamilyMemberArray(familyMembers);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        Application app = new Application();
        app.getFamilyService().addFamily(family);
        GetFamilyMembersListController controller = new GetFamilyMembersListController(app);
        //Act
        boolean result = controller.getFamilyMembersAndRelation(2, diogo.getID());
        //Assert
        //As nothing has been added to expected both lists are Empty, as predicted
        assertFalse(result);
    }


}