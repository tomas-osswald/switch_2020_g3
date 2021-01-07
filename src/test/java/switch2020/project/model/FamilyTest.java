package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    int id = 1111;
    String name = "Diogo";
    String date = "26/08/1990";
    int numero = 919999999;
    //PhoneNumber phone = new PhoneNumber(numero);
    //ArrayList<PhoneNumber> phoneNumbers = new ArrayList();
    //phoneNumbers.add(phone);
    String email = "josediogoccbr@gmail.com";
    //EmailAddress emails = new EmailAddress(email);
    //ArrayList<EmailAddress> emailAddressArrayList = new ArrayList();
    int nif = 212122233;
    //VatNumber vat = new VatNumber(nif);
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    //Address address = new Address(rua,codPostal,local,city);
    String relacao = "filho";
    Relationship relation = new Relationship(relacao);
    boolean admin = false;

    @Test /** Test if Family Member is added to Family **/
    void addFamilyMember() {
        FamilyMember Diogo = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        Family Ribeiros = new Family(1);
        Ribeiros.addFamilyMember(Diogo);
        Family expected = new Family(1,Diogo);
        assertEquals(Ribeiros, expected);
    }
}