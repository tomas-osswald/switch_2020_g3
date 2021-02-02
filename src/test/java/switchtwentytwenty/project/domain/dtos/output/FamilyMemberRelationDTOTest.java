package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.user_data.CCNumber;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberRelationDTOTest {

    String cc = "000000000ZZ4";
    CCNumber ccNumber = new CCNumber(cc);
    String name = "Diogo";
    java.util.Date date = new java.util.Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";

    @Test
    void compareSameInstance() {
        FamilyMember familyMemberOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        FamilyMember familyMemberTwo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Relation relation = new Relation("Pais", familyMemberOne, familyMemberTwo, true);
        FamilyMemberRelationDTO familyMemberRelationDTO =  new FamilyMemberRelationDTO(relation);

        assertSame(familyMemberRelationDTO, familyMemberRelationDTO);
        assertEquals(familyMemberRelationDTO, familyMemberRelationDTO);
    }
}