package switch2020.project.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FamilyTest {

    @Test
    public void testGetFamilyMembers(){
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
    }

}