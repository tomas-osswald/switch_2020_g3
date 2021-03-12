package switchtwentytwenty.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.BankAccount;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.user_data.*;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {


    //Family Member Diogo
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

    boolean admin = false;

    //Setup for MemberProfileDTO testing
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
    String relacao2 = "primo";

    boolean admin2 = false;

    //Setup for FamilyMemberDTO

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    //FamilyMember diogoClone = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember diogoNoAdmin = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    FamilyMember newMember = new FamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2);
    Relation relation2 = new Relation(relacao2, diogo, jorge, false);
    Relation relation = new Relation(relacao, jorge, diogo, false);

    double balance = 0.6;
    double negativeBalance = -2;
    String accountName = "Current Account";
    String accountName2 = "Other Current Account";


    /**
     * Name Validation
     **/
    /* Empty with Admin */
    @Test
    void NotCreateMember_NameEmpty_Admin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "", date, numero, email, nif, rua, codPostal, local, city, admin));
    }

    /* Empty with NoAdmin */
    @Test
    void NotCreateMember_NameEmpty_NoAdmin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "", date, numero, email, nif, rua, codPostal, local, city));
    }

    /* Blank with Admin */
    @Test
    void NotCreateMember_NameBlank_Admin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "      ", date, numero, email, nif, rua, codPostal, local, city, admin));
    }

    /* Blank with NoAdmin */
    @Test
    void NotCreateMember_NameBlank_NoAdmin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, "      ", date, numero, email, nif, rua, codPostal, local, city));
    }

    /* Null with Admin */
    @Test
    void NotCreateMember_NameNull_Admin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, null, date, numero, email, nif, rua, codPostal, local, city, admin));
    }

    /* Null with NoAdmin */
    @Test
    void NotCreateMember_NameNull_NoAdmin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, null, date, numero, email, nif, rua, codPostal, local, city));
    }

    /* Valid with Admin */
    @Test
    void CreateMember_NameValid_Admin() {
        FamilyMember person = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        assertTrue(person.validateName(name));
    }

    /* Valid with NoAdmin */
    @Test
    void CreateMember_NameValid_NoAdmin() {
        FamilyMember person = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        assertTrue(person.validateName(name));
    }

    /**
     * BirthDate Validation
     **/
    /* Null with Admin */
    @Test
    void NotCreateMember_BirthDateNull_Admin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, name, null, numero, email, nif, rua, codPostal, local, city, admin));
    }

    /* Null with NoAdmin */
    @Test
    void NotCreateMember_BirthDateNull_NoAdmin() {
        assertThrows(IllegalArgumentException.class, () -> new FamilyMember(cc, name, null, numero, email, nif, rua, codPostal, local, city));
    }

    /* Valid with Admin */
    @Test
    void CreateMember_BirthDateValid_Admin() {
        FamilyMember person = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        assertNotNull(person);
    }

    /* Valid with NoAdmin */
    @Test
    void CreateMember_BirthDateValid_NoAdmin() {
        FamilyMember person = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        assertNotNull(person);
    }

    /**
     * PhoneNumber
     **/
    /* Valid Null with NoAdmin */
    @Test
    void CreateMember_PhoneNull_NoAdmin() {
        Integer phone = null;
        FamilyMember person = new FamilyMember(cc, name, date, phone, email, nif, rua, codPostal, local, city);
        assertFalse(person.validatePhone(phone));
    }

    /**
     * Email
     **/
    /* Valid Null with NoAdmin */
    @Test
    void CreateMember_EmailNull_NoAdmin() {
        String emailx = null;
        FamilyMember person = new FamilyMember(cc, name, date, numero, emailx, nif, rua, codPostal, local, city);
        assertFalse(person.validateEmail(emailx));
    }

    /********* SEM EFEITO

     // VatNumber Validation
     // Null with Admin
     @Test void NotCreateMember_VatNull_Admin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,0,rua,codPostal,local,city,relation, admin));
     }

     // Null with NoAdmin
     @Test void NotCreateMember_VatNull_NoAdmin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,0,rua,codPostal,local,city,relation));
     }

     // Incorrect Numbers with Admin
     @Test void NotCreateMember_VatIncorrectNumbers_Admin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,12345678,rua,codPostal,local,city,relation, admin));
     }

     // Incorrect Numbers with NoAdmin
     @Test void NotCreateMember_VatIncorrectNumbers_NoAdmin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,numero,email,12345678,rua,codPostal,local,city,relation));
     }

     // Valid with Admin
     @Test void CreateMember_VatNumberValid_Admin() {
     FamilyMember person = new FamilyMember(id,name,date,numero,email,123456789,rua,codPostal,local, city, relation, admin);
     assertTrue(person.validateVat(123456789));
     }

     // Valid with NoAdmin
     @Test void CreateMember_VatNumberValid_NoAdmin() {
     FamilyMember person = new FamilyMember(id,name,date,numero,email,123456789,rua,codPostal,local, city, relation);
     assertTrue(person.validateVat(123456789));
     }

     // PhoneNumber Validation
     // Null with Admin
     @Test void NotCreateMember_PhoneNull_Admin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,0,email,nif,rua,codPostal,local,city,relation, admin));
     }

     // Null with NoAdmin
     @Test void NotCreateMember_PhoneNull_NoAdmin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,0,email,nif,rua,codPostal,local,city,relation));
     }

     // Incorrect Numbers with Admin
     @Test void NotCreateMember_PhoneIncorrectNumbers_Admin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,91765432,email,nif,rua,codPostal,local,city,relation, admin));
     }

     // Incorrect Numbers with NoAdmin
     @Test void NotCreateMember_PhoneIncorrectNumbers_NoAdmin() {
     assertThrows(IllegalArgumentException.class,()-> new FamilyMember(id,name,date,91765432,email,nif,rua,codPostal,local,city,relation));
     }

     // Valid with Admin
     @Test void CreateMember_PhoneValid_Admin() {
     FamilyMember person = new FamilyMember(id,name,date,917654321,email,nif,rua,codPostal,local,city,relation,admin);
     assertTrue(person.validatePhone(917654321));
     }

     // Valid with NoAdmin
     @Test void CreateMember_PhoneValid_NoAdmin() {
     FamilyMember person = new FamilyMember(id,name,date,917654321,email,nif,rua,codPostal,local,city,relation);
     assertTrue(person.validatePhone(917654321));
     }
     *********/


    //get MemberProfileDTO from diogo's information and compares method using diogo to create MemberProfileDTO
    @Test
    void getMemberProfileTest1_objectsAreEqual() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = diogoNoAdmin.createProfile();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    //compares diogo, but creates MemberProfileDTO from jorge
    @Test
    void getMemberProfileTest2_objectsAreNotEqual() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = jorge.createProfile();

        assertNotEquals(expected, result);
    }

    @Test
    void getMemberProfileTest3_AdministratorTrueObjectsAreEqual() {

        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        FamilyMember admin = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, true);

        MemberProfileDTO result = admin.createProfile();
        //Assert
        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    //tests MemberProfileDTO using FamilyMember constructor to create admins
    @Test
    void getMemberProfileTest4_AdministratorTrueObjectsAreNotEqual() {
        emails.add(emailAddress);
        phoneNumbers.add(phoneNumber);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, true);

        MemberProfileDTO result = jorge.createProfile();

        assertNotEquals(expected, result);
    }

    @Test
    void getMemberProfileTest5_objectsAreEqualInvalidEmail() {
        phoneNumbers.add(phoneNumber);
        FamilyMember joaquim = new FamilyMember(cc, name, date, numero, null, nif, rua, codPostal, local, city);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = joaquim.createProfile();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getMemberProfileTest6_objectsAreNotEqualInvalidEmail() {
        phoneNumbers.add(phoneNumber);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = diogo.createProfile();

        assertNotEquals(expected, result);
    }

    @Test
    void getMemberProfileTest7_objectsAreEqualInvalidPhoneNumber() {
        emails.add(emailAddress);
        FamilyMember joaquim = new FamilyMember(cc, name, date, null, email, nif, rua, codPostal, local, city);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = joaquim.createProfile();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getMemberProfileTest8_objectsAreNotEqualInvalidPhoneNumbers() {
        emails.add(emailAddress);
        MemberProfileDTO expected = new MemberProfileDTO(ccNumber, name, date, phoneNumbers, emails, vatNumber, address, admin);

        MemberProfileDTO result = diogo.createProfile();

        assertNotEquals(expected, result);
    }


    @Test
    void addAccount_BankAccount() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        BankAccount bankAccount = new BankAccount(addBankAccountDTO, 1);
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        diogo.addAccount(bankAccount);
        assertTrue(diogo.getAccounts().get(0) == bankAccount);
    }

    @Test
    void getAccount() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        BankAccount bankAccount = new BankAccount(addBankAccountDTO, 1);
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        diogo.addAccount(bankAccount);

        Account expected = bankAccount;

        Account result = diogo.getAccount(1);

        assertEquals(expected, result);

    }

    @Test
    void getAccount_ExpectedFail() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        BankAccount bankAccount = new BankAccount(addBankAccountDTO, 1);
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        diogo.addAccount(bankAccount);

        Account expected = null;

        Account result = diogo.getAccount(3);

        assertEquals(expected, result);
    }


    @Test
    void addEmail_ValidEmail() {
        EmailAddress newEmail = new EmailAddress("1120717@isep.ipp.pt");
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);

        boolean result = diogo.addEmail(newEmail);

        assertTrue(result);
    }


    @Test
    void testEquals_differentObjects() {
        FamilyMember person = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        Family notPerson = new Family("testFamily", 0);

        Assertions.assertNotEquals(person, notPerson);
    }

    @Test
    void testEquals_differentPersons() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        FamilyMember personTwo = new FamilyMember(id2, name, date, numero, email, nif, rua, codPostal, local, city, admin);

        Assertions.assertNotEquals(personOne, personTwo);
    }

    @Test
    void testEquals_samePerson() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        FamilyMember personTwo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);

        Assertions.assertEquals(personOne, personTwo);
        Assertions.assertNotSame(personOne, personTwo);
    }

    @Test
    void addAccount_failureAccountIsNull() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);

        boolean result = personOne.addAccount(null);

        Assertions.assertFalse(result);
    }

    @Test
    void testHashCodeNotEquals() {
        int hash1 = diogo.hashCode();
        int hash2 = jorge.hashCode();
        assertNotEquals(hash1, hash2);
    }


    @Test
    void testHashCodeNotZero() {
        int hash1 = diogo.hashCode();
        int hash2 = 0;
        assertNotEquals(hash1, hash2);
    }

    @Test
    void hasCashAccount_FalseNoAccount() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);

        boolean result = personOne.hasCashAccount();

        Assertions.assertFalse(result);
    }

    @Test
    void hasCashAccount_FalseOtherAccount() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        BankAccount bankAccount = new BankAccount(addBankAccountDTO, 1);
        personOne.addAccount(bankAccount);
        boolean result = personOne.hasCashAccount();

        Assertions.assertFalse(result);
    }

    @Test
    void hasCashAccount_True() {
        FamilyMember personOne = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
        CashAccount cashAccount = new CashAccount("CashAccount", 200.0, 1, CurrencyEnum.EURO);
        personOne.addAccount(cashAccount);
        boolean result = personOne.hasCashAccount();

        Assertions.assertTrue(result);
    }

    @Test
    void addAnAccountTrue() {
        AddBankAccountDTO dto = new AddBankAccountDTO(balance, "description", "selfCC", 1, CurrencyEnum.EURO);
        BankAccount account = new BankAccount(dto, 1);

        assertTrue(diogo.addAccount(account));
    }
}