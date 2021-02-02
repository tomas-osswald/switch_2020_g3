package switchtwentytwenty.project.domain.model;


import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.user_data.Address;
import switchtwentytwenty.project.domain.model.user_data.EmailAddress;
import switchtwentytwenty.project.domain.model.user_data.PhoneNumber;
import switchtwentytwenty.project.domain.model.user_data.VatNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RelationTest {


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

    @Test
    void creatingRelation() {
        assertDoesNotThrow(() -> {
            Relation newRelation = new Relation("Filho", diogo, jorge, false);
        });

    }

    @Test
    void getRelationDesisgnation() {
        Relation newRelation = new Relation("Filho", diogo, jorge, false);
        String expected = "Filho";
        String result = newRelation.getRelationDesignation();
        assertEquals(expected, result);
    }


    @Test
    void instationOfARelationObjectWithInvalidArgumentsNull() {
        String relationDesignation = null;

        assertThrows(Exception.class, () -> new Relation(relationDesignation, diogo, jorge, false));
    }

    @Test
    void instationOfARelationObjectWithInvalidArgumentsEmpty() {
        String relationDesignation = "";

        assertThrows(Exception.class, () -> new Relation(relationDesignation, diogo, jorge, false));
    }

    @Test
    void compareRelationTrue() {
        String relationDesignation1 = "Father";


        Relation relation1 = new Relation(relationDesignation1, diogo, jorge, false);
        Relation relation2 = new Relation(relationDesignation1, diogo, jorge, false);

        assertNotSame(relation1, relation2);
        assertEquals(relation1, relation2);
    }

    @Test
    void compareRelationFalse() {
        String relationDesignation1 = "Father";
        String relationDesignation2 = "Mother";

        Relation relation1 = new Relation(relationDesignation1, diogo, jorge, false);
        Relation relation2 = new Relation(relationDesignation2, diogo, jorge, false);

        assertNotSame(relation1, relation2);
        assertNotEquals(relation1, relation2);
    }

    @Test
    void compareSameRelation() {
        String relationDesignation = "Mother";

        Relation relation = new Relation(relationDesignation, diogo, jorge, false);

        assertEquals(relation, relation);
        assertSame(relation, relation);
    }

    @Test
    void compareRelationWithOtherClass() {
        String relationDesignation = "Mother";

        Relation relation = new Relation(relationDesignation, diogo, jorge, false);

        Object objectToCompare = new Object();

        assertNotEquals(relation, objectToCompare);
        assertNotSame(relation, objectToCompare);
    }


    @Test
    void testHashCode_DifferentObjects_ExpectingEquals() {
        Relation newRelation = new Relation("Pai", diogo, jorge, true);
        Relation newRelationTwo = new Relation("Pai", diogo, jorge, true);
        assertEquals(newRelation.hashCode(), newRelationTwo.hashCode());

    }

    @Test
    void testHashCode_DifferentObjects_ExpectingNotEquals_notParent() {
        Relation newRelation = new Relation("Pai", diogo, jorge, true);
        Relation newRelationTwo = new Relation("Pai", diogo, jorge, false);
        assertNotEquals(newRelation.hashCode(), newRelationTwo.hashCode());

    }

    @Test
    void testHashCode_DifferentObjects_ExpectingNotEquals_differentDesignation() {
        Relation newRelation = new Relation("mãe", diogo, jorge, true);
        Relation newRelationTwo = new Relation("Pai", diogo, jorge, false);
        assertNotEquals(newRelation.hashCode(), newRelationTwo.hashCode());

    }

    @Test
    void testHashCode_SameObjects_ExpectingEquals() {
        Relation newRelation = new Relation("Pai", diogo, jorge, true);
        Family family = new Family("Simpsons", 123);
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        family.addRelation(newRelation);
        Family familyTwo = new Family("Griffin", 456);
        familyTwo.addFamilyMember(diogo);
        familyTwo.addFamilyMember(jorge);
        familyTwo.addRelation(newRelation);
        assertEquals(newRelation.hashCode(), newRelation.hashCode());
    }




}

