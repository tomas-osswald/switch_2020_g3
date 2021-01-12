package switch2020.project.model;

import org.junit.jupiter.api.Test;
import switch2020.project.utils.MemberProfileDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {

    //Family Member Diogo
    int id = 1111;
    String name = "Diogo";
    Date date = new Date(1990,8,26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);
    boolean admin = false;


    //Family Member Tony
    int id2 = 2222;
    String name2 = "Tony";
    Date date2 = new Date(1954,8,26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    //Setup for FamilyMemberDTO
    FamilyMember diogo = new FamilyMember(id, name, date,numero,email,nif,rua,codPostal,local, city, relation, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, relation2, admin2);

    @Test
    public void createFamilyMember() {
        FamilyMember José = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        String expected = "filho";
        String result = José.getRelation();
        assertTrue(expected.equals(result));
        assertTrue(name.equals(José.getName()));
    }

    /** Name Validation **/
    /* Empty with Admin */
    @Test
    void NotCreateMember_NameEmpty_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"",date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    /* Empty with NoAdmin */
    @Test
    void NotCreateMember_NameEmpty_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"",date,numero,email,nif,rua,codPostal,local,city,relation));
    }

    /* Blank with Admin */
    @Test
    void NotCreateMember_NameBlank_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"      ",date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    /* Blank with NoAdmin */
    @Test
    void NotCreateMember_NameBlank_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,"      ",date,numero,email,nif,rua,codPostal,local,city,relation));
    }

    /* Null with Admin */
    @Test
    void NotCreateMember_NameNull_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,null,date,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    /* Null with NoAdmin */
    @Test
    void NotCreateMember_NameNull_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,null,date,numero,email,nif,rua,codPostal,local,city,relation));
    }

    /* Valid with Admin */
    @Test
    void CreateMember_NameValid_Admin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local,city,relation,admin);
        assertTrue(person.validateName(name));
    }

    /* Valid with NoAdmin */
    @Test
    void CreateMember_NameValid_NoAdmin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local,city,relation);
        assertTrue(person.validateName(name));
    }

    /** BirthDate Validation **/
    /* Null with Admin */
    @Test
    void NotCreateMember_BirthDateNull_Admin() {
        assertThrows(NullPointerException.class,()-> new FamilyMember(id,name,null,numero,email,nif,rua,codPostal,local,city,relation, admin));
    }

    /* Null with NoAdmin */
    @Test
    void NotCreateMember_BirthDateNull_NoAdmin() {
        assertThrows(NullPointerException.class,()-> new FamilyMember(id,name,null,numero,email,nif,rua,codPostal,local,city,relation));
    }

    /* Valid with Admin */
    @Test
    void CreateMember_BirthDateValid_Admin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation, admin);
        assertTrue(person.validateBirthDate(date));
    }

    /* Valid with NoAdmin */
    @Test
    void CreateMember_BirthDateValid_NoAdmin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,nif,rua,codPostal,local, city, relation);
        assertTrue(person.validateBirthDate(date));
    }

    /** PhoneNumber **/
    /* Valid Null with NoAdmin */
    @Test
    void CreateMember_PhoneNull_NoAdmin() {
        Integer phone = null;
        FamilyMember person = new FamilyMember(id,name,date,phone,email,nif,rua,codPostal,local,city,relation);
        assertFalse(person.validatePhone(phone));
    }

    /** Email **/
    /* Valid Null with NoAdmin */
    @Test
    void CreateMember_EmailNull_NoAdmin() {
        String emailx = null;
        FamilyMember person = new FamilyMember(id,name,date,numero,emailx,nif,rua,codPostal,local,city,relation);
        assertFalse(person.validateEmail(emailx));
    }

    /********* SEM EFEITO

    // VatNumber Validation
    // Null with Admin
    @Test
    void NotCreateMember_VatNull_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,0,rua,codPostal,local,city,relation, admin));
    }

    // Null with NoAdmin
    @Test
    void NotCreateMember_VatNull_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,0,rua,codPostal,local,city,relation));
    }

    // Incorrect Numbers with Admin
    @Test
    void NotCreateMember_VatIncorrectNumbers_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,12345678,rua,codPostal,local,city,relation, admin));
    }

    // Incorrect Numbers with NoAdmin
    @Test
    void NotCreateMember_VatIncorrectNumbers_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,12345678,rua,codPostal,local,city,relation));
    }

    // Valid with Admin
    @Test
    void CreateMember_VatNumberValid_Admin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,123456789,rua,codPostal,local, city, relation, admin);
        assertTrue(person.validateVat(123456789));
    }

    // Valid with NoAdmin
    @Test
    void CreateMember_VatNumberValid_NoAdmin() {
        FamilyMember person = new FamilyMember(id,name,date,numero,email,123456789,rua,codPostal,local, city, relation);
        assertTrue(person.validateVat(123456789));
    }

    // PhoneNumber Validation
    // Null with Admin
    @Test
    void NotCreateMember_PhoneNull_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,0,email,nif,rua,codPostal,local,city,relation, admin));
    }

    // Null with NoAdmin
    @Test
    void NotCreateMember_PhoneNull_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,0,email,nif,rua,codPostal,local,city,relation));
    }

    // Incorrect Numbers with Admin
    @Test
    void NotCreateMember_PhoneIncorrectNumbers_Admin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,91765432,email,nif,rua,codPostal,local,city,relation, admin));
    }

    // Incorrect Numbers with NoAdmin
    @Test
    void NotCreateMember_PhoneIncorrectNumbers_NoAdmin() {
        assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,91765432,email,nif,rua,codPostal,local,city,relation));
    }

    // Valid with Admin
    @Test
    void CreateMember_PhoneValid_Admin() {
        FamilyMember person = new FamilyMember(id,name,date,917654321,email,nif,rua,codPostal,local,city,relation,admin);
        assertTrue(person.validatePhone(917654321));
    }

    // Valid with NoAdmin
    @Test
    void CreateMember_PhoneValid_NoAdmin() {
        FamilyMember person = new FamilyMember(id,name,date,917654321,email,nif,rua,codPostal,local,city,relation);
        assertTrue(person.validatePhone(917654321));
    }

    *********/
    // Falta ainda testar o throw para o constructor de FamilyMember.


    //get MemberProfileDTO from diogo's information and compares method using diogo to create MemberProfileDTO
    @Test
    void getMemberProfileTest1_objectsAreEqual() {
        //Arrange
        Address address = new Address(rua, codPostal, local, city);

        EmailAddress emailAddress = new EmailAddress(email);
        List<EmailAddress> emails = new ArrayList<>();
        emails.add(emailAddress);

        PhoneNumber phoneNumber = new PhoneNumber(numero);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);

        VatNumber vatNumber = new VatNumber(nif);

        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, relation, admin);
        //Act
        MemberProfileDTO result = diogo.createProfile();
        //Assert
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    //compares diogo, but creates MemberProfileDTO from jorge
    @Test
    void getMemberProfileTest2_objectsAreNotEqual() {
        //Arrange
        Address address = new Address(rua, codPostal, local, city);

        EmailAddress emailAddress = new EmailAddress(email);
        List<EmailAddress> emails = new ArrayList<>();
        //emails.add(emailAddress);

        PhoneNumber phoneNumber = new PhoneNumber(numero);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);

        VatNumber vatNumber = new VatNumber(nif);

        MemberProfileDTO expected = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, relation, admin);
        //Act
        MemberProfileDTO result = jorge.createProfile();
        //Assert
        assertNotEquals(expected, result);
    }

}