package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetFamilyMembersListControllerTest {
    ArrayList<FamilyMember> osBatistas = new ArrayList<>();
    ArrayList<FamilyMember> osFelix = new ArrayList<>();
    Relation filho = new Relation("filho");
    FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
    FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
    FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
    Family Batista = new Family(200489, osBatistas);
    Family Alves = new Family(123, osBatistas);
    Family Felix = new Family(456, osFelix);
    ArrayList<Family> families = new ArrayList<>();
    Application FFMapp = new Application();

    GetFamilyMembersListController getMembersDTO = new GetFamilyMembersListController(FFMapp);
    FamilyMemberRelationDTO memberOne = new FamilyMemberRelationDTO("Ricardo", "filho");
    FamilyMemberRelationDTO memberTwo = new FamilyMemberRelationDTO("Jorge", "filho");
    FamilyMemberRelationDTO memberThree = new FamilyMemberRelationDTO("Woody", "filho");
    ArrayList<FamilyMemberRelationDTO> expected = new ArrayList();


    @Test
    void getFamilyMemberAndRelation() {
        FFMapp.getFamilyService().addFamily(Batista);
        FFMapp.getFamilyService().addFamily(Alves);
        FFMapp.getFamilyService().addFamily(Felix);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        families.add(Batista);
        families.add(Alves);
        families.add(Felix);
        expected.add(memberOne);
        expected.add(memberTwo);
        expected.add(memberThree);
        ArrayList<FamilyMemberRelationDTO> result = getMembersDTO.getFamilyMemberAndRelation(200489);
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
}