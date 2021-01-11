package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {

    int id = 1111;
    String name = "Diogo";
    String date = "26/08/1990";
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

    // Falta ainda testar o throw para o constructor de FamilyMember.


}