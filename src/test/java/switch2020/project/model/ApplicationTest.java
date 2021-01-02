package switch2020.project.model;

import org.junit.jupiter.api.Test;
import switch2020.project.utils.FamilyMemberRelationshipDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testGetFamily() {
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Relationship filho = new Relationship("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        Family Batista = new Family(200489, osBatistas);
        Family Alves = new Family(123, osBatistas);
        Family Felix = new Family(456, osBatistas);
        ArrayList<Family> families = new ArrayList<>();
        families.add(Batista);
        families.add(Alves);
        families.add(Felix);
        Application FFMapp = new Application(families);
        Family expected = Batista;
        Family result = FFMapp.getFamily(200489);
        assertEquals(expected, result);
    }

    @Test
    void testGetFamilyMembers() {
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Relationship filho = new Relationship("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        Family Batista = new Family(200489, osBatistas);
        Family Alves = new Family(123, osBatistas);
        Family Felix = new Family(456, osBatistas);
        ArrayList<Family> families = new ArrayList<>();
        families.add(Batista);
        families.add(Alves);
        families.add(Felix);
        Application FFMapp = new Application(families);
        ArrayList<FamilyMember> expected = Batista.getMembers();
        ArrayList<FamilyMember> result = FFMapp.getFamilyMembers(200489);
        assertEquals(expected, result);
    }

    @Test
    void getDTOList() {
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Relationship filho = new Relationship("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        Family Batista = new Family(200489, osBatistas);
        Family Alves = new Family(123, osBatistas);
        Family Felix = new Family(456, osBatistas);
        ArrayList<Family> families = new ArrayList<>();
        families.add(Batista);
        families.add(Alves);
        Application FFMapp = new Application(families);
        FamilyMemberRelationshipDTO memberOne = new FamilyMemberRelationshipDTO("Ricardo", "filho");
        FamilyMemberRelationshipDTO memberTwo = new FamilyMemberRelationshipDTO("Jorge", "filho");
        FamilyMemberRelationshipDTO memberThree = new FamilyMemberRelationshipDTO("Woody", "filho");
        ArrayList<FamilyMemberRelationshipDTO> expected = new ArrayList();
        expected.add(memberOne);
        expected.add(memberTwo);
        expected.add(memberThree);
        ArrayList<FamilyMemberRelationshipDTO> result = new ArrayList<>();
        result = FFMapp.getDTOList(200489);
        assertEquals(expected, result);

    }
}