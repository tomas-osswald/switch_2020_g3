package switch2020.project.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {

    int id = 1111;
    String name = "Diogo";
    Date date = new Date(1990,8,26);
    int numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = false;

    @Test
    public void createFamilyMember() {
        FamilyMember José = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        String expected = "filho";
        String result = José.getRelation();
        assertTrue(expected.equals(result));
        assertTrue(name.equals(José.getName()));
    }

    @Test
    void NotCreateMember_NameEmpty() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"",date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    @Test
    void NotCreateMember_NameBlank() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"      ",date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    @Test
    void NotCreateMember_NameNull() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,null,date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    @Test
    void CreateMember_NameValid() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local,city,relation,admin);
        assertTrue(person.validateName(name));
    }

    @Test
    void NotCreateMember_BirthDateNull() {
        assertThrows(NullPointerException.class,()-> new FamilyMember(id,name,null,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    @Test
    void CreateMember_BirthDateValid() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        assertTrue(person.validateBirthDate(date));
    }


    // Falta ainda testar o throw para o constructor de FamilyMember.
}