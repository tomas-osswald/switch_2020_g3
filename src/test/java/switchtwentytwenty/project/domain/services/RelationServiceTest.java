package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.model.user_data.Address;
import switchtwentytwenty.project.domain.model.user_data.EmailAddress;
import switchtwentytwenty.project.domain.model.user_data.PhoneNumber;
import switchtwentytwenty.project.domain.model.user_data.VatNumber;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class RelationServiceTest {
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

    boolean admin = false;


    Address address = new Address(rua, codPostal, local, city);

    EmailAddress emailAddress = new EmailAddress(email);
    List<EmailAddress> emails = new ArrayList<>();

    PhoneNumber phoneNumber = new PhoneNumber(numero);
    List<PhoneNumber> phoneNumbers = new ArrayList<>();

    VatNumber vatNumber = new VatNumber(nif);


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


    boolean admin2 = false;

    //Setup for RelationCreation

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    Family family = new Family("Ribeiro", 1);


    @Test
    void getFamilyMembersRelationDTOList() {
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        Relation relation = new Relation("Filho", diogo, jorge, false);
        family.addRelation(relation);

        FamilyMemberRelationDTO expectedDTO = new FamilyMemberRelationDTO(relation);
        List<FamilyMemberRelationDTO> expected = new ArrayList<>();
        expected.add(expectedDTO);

        RelationService relationService = new RelationService();
        List<FamilyMemberRelationDTO> result = relationService.getFamilyMembersRelationDTOList(family);


        Assertions.assertEquals(expected, result);
        Assertions.assertNotSame(expected, result);
    }

    @Test
    void checkIfMemberAisParentOfBTrue() {
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        Relation relation = new Relation("Filho", diogo, jorge, true);
        family.addRelation(relation);
        RelationService relationService = new RelationService();
        boolean result = relationService.checkIfMemberAisParentOfB(family, diogo, jorge);
        Assertions.assertTrue(result);
    }

    @Test
    void checkIfMemberAisParentOfBFalse() {
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        Relation relation = new Relation("Filho", diogo, jorge, false);
        family.addRelation(relation);
        RelationService relationService = new RelationService();
        boolean result = relationService.checkIfMemberAisParentOfB(family, diogo, jorge);
        Assertions.assertFalse(result);
    }

    @Test
    void checkIfMemberAisParentOfBNoRelation() {
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        RelationService relationService = new RelationService();
        boolean result = relationService.checkIfMemberAisParentOfB(family, diogo, jorge);
        Assertions.assertFalse(result);
    }
}