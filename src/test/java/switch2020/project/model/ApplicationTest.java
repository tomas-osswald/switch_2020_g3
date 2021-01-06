package switch2020.project.model;

<<<<<<< HEAD
=======
import org.junit.jupiter.api.Test;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;

>>>>>>> feature/US104
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

<<<<<<< HEAD
=======
    @Test
    void testGetFamily() {
        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Relation filho = new Relation("filho");
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
        Relation filho = new Relation("filho");
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
        Relation filho = new Relation("filho");
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
        FamilyMemberRelationDTO memberOne = new FamilyMemberRelationDTO("Ricardo", "filho");
        FamilyMemberRelationDTO memberTwo = new FamilyMemberRelationDTO("Jorge", "filho");
        FamilyMemberRelationDTO memberThree = new FamilyMemberRelationDTO("Woody", "filho");
        ArrayList<FamilyMemberRelationDTO> expected = new ArrayList();
        expected.add(memberOne);
        expected.add(memberTwo);
        expected.add(memberThree);
        ArrayList<FamilyMemberRelationDTO> result = new ArrayList<>();
        result = FFMapp.getDTOList(200489);
        assertEquals(expected, result);

    }
>>>>>>> feature/US104
}