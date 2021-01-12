package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class addFamilyMemberTest {


    String ccNumber = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = true;

    String ccNumber2 = "137843828ZX3";
    String name2 = "xxxx";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "abcd@gmail.com";
    int nif2 = 212122234;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "ccccc";
    String city2 = "Porto";
    String relacao2 = "filho";
    Relation relation2 = new Relation(relacao);
    boolean admin2 = false;

    @Test
    /** Test if Family Member is added to Family **/
    void AddFamilyMember_FamilyExists() {
        FamilyMember Diogo = new FamilyMember(ccNumber, name, date, numero, email, nif, rua, codPostal, local, city, relation,admin);
        String familyName = "Ribeiro";
        int familyID = 1;
        Family Ribeiros = new Family(familyName, familyID);
        Ribeiros.addFamilyMember(Diogo);
        Application app = new Application(Ribeiros);
        AddFamilyMemberController FFMapp = new AddFamilyMemberController(app);
        assertTrue(FFMapp.addFamilyMember(ccNumber, ccNumber2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, 1));
    }


    @Test
    void NotAddFamilyMember_FamilyNotExists(){
        String familyName = "Ribeiro";
        int familyID = 1;
        Family Ribeiros = new Family(familyName, familyID);
        Application app = new Application(Ribeiros);
        AddFamilyMemberController FFMapp = new AddFamilyMemberController(app);
        assertFalse(FFMapp.addFamilyMember(ccNumber2, ccNumber,name,date,numero,email,nif,rua,codPostal,local, city, relation,2));
    }

    @Test
    /** Missing data entry validation : name, date, phone, email etc **/
    void NotAddFamilyMember_WrongDataEntry() {
        /*
        Family Ribeiros = new Family(1);
        FamilyService service = new FamilyService(Ribeiros);
        assertFalse(service.addFamilyMember(name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,relation2,1));
         */
    }

}