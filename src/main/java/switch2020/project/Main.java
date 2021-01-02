package switch2020.project;


import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relationship;
import switch2020.project.utils.FamilyMemberRelationshipDTO;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("OK!");

        ArrayList<FamilyMember> osBatistas = new ArrayList<>();
        Family Batista = new Family(200489, osBatistas);
        Relationship filho = new Relationship("filho");
        FamilyMember filhoOne = new FamilyMember("Ricardo", filho, 123);
        FamilyMember filhoTwo = new FamilyMember("Jorge", filho, 123456);
        FamilyMember filhoThree = new FamilyMember("Woody", filho, 123456789);
        osBatistas.add(filhoOne);
        osBatistas.add(filhoTwo);
        osBatistas.add(filhoThree);
        System.out.println(Batista.getMembers());

    }


}
