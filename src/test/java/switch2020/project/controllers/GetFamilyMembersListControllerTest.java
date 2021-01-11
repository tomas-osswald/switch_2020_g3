package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetFamilyMembersListControllerTest {

    int id = 1111;
    String name = "Diogo";
    String date = "26/08/1990";
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

    //Added 3rd FamilyMember to test
    int id3 = 3333;
    String name3 = "TonyZe";
    String date3 = "26/08/1955";
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

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, admin2);
    FamilyMember manuelAdmin = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, relation3, admin3);
    int familyID = 123;
    int familyTwoID = 456;
    int familyThreeID = 789;
    Family family = new Family(familyID);
    Family familyTwo = new Family(familyTwoID);
    Family familyThree = new Family(familyThreeID);
    ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    FamilyMemberRelationDTO diogoDTO = new FamilyMemberRelationDTO(diogo.getName(), diogo.getRelation());
    FamilyMemberRelationDTO jorgeDTO = new FamilyMemberRelationDTO(jorge.getName(), jorge.getRelation());
    FamilyMemberRelationDTO manuelAdminDTO = new FamilyMemberRelationDTO(manuelAdmin.getName(), manuelAdmin.getRelation());
    List<FamilyMemberRelationDTO> expected = new ArrayList<FamilyMemberRelationDTO>();


    @Test
    void getFamilyMemberAndRelation() {
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
            Application app = new Application();
            GetFamilyMembersListController test = new GetFamilyMembersListController(app);
            app.getFamilyService().addFamily(family);
            //Act
            List<FamilyMemberRelationDTO> result = test.getFamilyMemberAndRelation(family.getFamilyID(), manuelAdmin.getID());
            //Assert
            assertEquals(expected, result);
            assertNotSame(expected, result);
        }

        @Test
        void getDTOList_TestWithNoAdministratorExpectingEmptyListAsReturn() {
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
            List<FamilyMemberRelationDTO> result = controller.getFamilyMemberAndRelation(family.getFamilyID(), diogo.getID());
            //Assert
            assertEquals(expected, result);
            assertNotSame(expected, result);
        }


}