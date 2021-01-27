package switch2020.project.domain.utils;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberRelationDTOTest {

    //Family Member Diogo
    String cc = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    boolean admin = true;

    //Family Member Tony
    String id2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";

    boolean admin2 = false;

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);

    Relation relation = new Relation("Son", diogo, jorge, false);
    Relation relation2 = new Relation("Father", jorge, diogo, true);
    FamilyMemberRelationDTO test = new FamilyMemberRelationDTO(relation);

    @Test
    void getName() {
        String expected = "Diogo is Tony's Son";
        String result = test.getRelationDesignation();
        assertEquals(expected, result);
    }


    @Test
    void compareDTOWithAnotherClass() {
        String relationDesignatio = "Mother";
        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(relation2);

        assertNotSame(relation1, relationDesignatio);
        assertNotEquals(relation1, relationDesignatio);
    }

    @Test
    void compareTwoInstancesOfDTOEquals() {

        FamilyMemberRelationDTO relation1 = new FamilyMemberRelationDTO(relation);

        FamilyMemberRelationDTO relation2 = new FamilyMemberRelationDTO(relation);

        assertNotSame(relation1, relation2);
        assertEquals(relation1, relation2);
    }


}