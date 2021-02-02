package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Test;

import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.user_data.CCNumber;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberRelationDTOTest {


    //FamilyMember Setup parent
    String cc = "000000000ZZ4";
    CCNumber ccNumber = new CCNumber(cc);
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



    // FamilyMember setup child
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


    boolean administrator = true;
    Boolean noAdministrator = false;

    FamilyMember parent = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, administrator);
    FamilyMember child = new FamilyMember (id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, noAdministrator);


    @Test
    void compareSameInstance() {
        FamilyMember familyMemberOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        FamilyMember familyMemberTwo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Relation relation = new Relation("Pais", familyMemberOne, familyMemberTwo, true);
        FamilyMemberRelationDTO familyMemberRelationDTO =  new FamilyMemberRelationDTO(relation);

        assertSame(familyMemberRelationDTO, familyMemberRelationDTO);
        assertEquals(familyMemberRelationDTO, familyMemberRelationDTO);
    }

    @Test
    void testHashCode() {
        Relation newRelation = new Relation("Pai", parent, child, true);
        FamilyMemberRelationDTO expectedMember = new FamilyMemberRelationDTO(newRelation);
        FamilyMemberRelationDTO resultMember = new FamilyMemberRelationDTO(newRelation);

        assertEquals(expectedMember.hashCode(), resultMember.hashCode());

    }

    @Test
    void testHashCode_differentObjects() {
        Relation newRelation = new Relation("Pai", parent, child, true);
        Relation newRelationTwo = new Relation("Pai", parent, child, true);
        FamilyMemberRelationDTO expectedMember = new FamilyMemberRelationDTO(newRelation);
        FamilyMemberRelationDTO resultMember = new FamilyMemberRelationDTO(newRelationTwo);

        assertEquals(expectedMember.hashCode(), resultMember.hashCode());
    }

    @Test
    void testHashCode_differentObjects_notEqualsExpected_DifferentRelationDesignation() {
        Relation newRelation = new Relation("Pai", parent, child, true);
        Relation newRelationTwo = new Relation("Filho", parent, child, true);
        FamilyMemberRelationDTO expectedMember = new FamilyMemberRelationDTO(newRelation);
        FamilyMemberRelationDTO resultMember = new FamilyMemberRelationDTO(newRelationTwo);

        assertNotEquals(expectedMember.hashCode(), resultMember.hashCode());
    }

    @Test
    void testHashCode_differentObjects_notEqualsExpected_differentPermission() {
        Relation newRelation = new Relation("Pai", parent, child, true);
        Relation newRelationTwo = new Relation("Pai", parent, child, false);
        FamilyMemberRelationDTO expectedMember = new FamilyMemberRelationDTO(newRelation);
        FamilyMemberRelationDTO resultMember = new FamilyMemberRelationDTO(newRelationTwo);

        assertNotEquals(expectedMember.hashCode(), resultMember.hashCode());
    }



}