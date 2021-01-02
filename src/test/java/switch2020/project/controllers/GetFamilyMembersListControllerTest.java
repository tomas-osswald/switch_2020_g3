package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relationship;
import switch2020.project.utils.FamilyMemberRelationshipDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetFamilyMembersListControllerTest {

    @Test
    void getFamilyMemberAndRelationship() {
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        ArrayList<FamilyMember> osFelix = new ArrayList<>();
        Relationship filho = new Relationship("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        Family Batista = new Family(200489, osBatistas);
        Family Alves = new Family(123, osBatistas);
        Family Felix = new Family(456, osFelix);
        ArrayList<Family> families = new ArrayList<>();
        families.add(Batista);
        families.add(Alves);
        families.add(Felix);
        Application FFMapp = new Application(families);
        GetFamilyMembersListController getMembersDTO = new GetFamilyMembersListController(FFMapp);
        FamilyMemberRelationshipDTO memberOne = new FamilyMemberRelationshipDTO("Ricardo", "filho");
        FamilyMemberRelationshipDTO memberTwo = new FamilyMemberRelationshipDTO("Jorge", "filho");
        FamilyMemberRelationshipDTO memberThree = new FamilyMemberRelationshipDTO("Woody", "filho");
        ArrayList<FamilyMemberRelationshipDTO> expected = new ArrayList();
        expected.add(memberOne);
        expected.add(memberTwo);
        expected.add(memberThree);
        ArrayList<FamilyMemberRelationshipDTO> result = getMembersDTO.getFamilyMemberAndRelationship(200489);
        assertEquals(expected, result);
    }
}