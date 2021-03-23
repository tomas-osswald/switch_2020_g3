package switchtwentytwenty.project.domain.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.shared.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final int VALIDPHONENUMBER = 916969696;
    final String VALIDCCNUMBER = "156066866ZY1";
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final int VALIDADDRESSNUMBER = 69;
    Person validPerson;
    Person tonyZe;
    Name tonyZeName;
    EmailAddress tonyZeEmail;
    VATNumber tonyZeVat;
    PhoneNumber tonyZePhone;
    Address tonyZeAddress;
    CCnumber tonyZeCC;

    @BeforeEach
    void createValidPerson(){
        Name tonyZeName = new Name(VALIDNAME);
        EmailAddress tonyZeEmail = new EmailAddress(VALIDEMAIL);
        VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
        PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        CCnumber tonyZeCC = new CCnumber(VALIDCCNUMBER);
        validPerson = new Person(tonyZeName,tonyZeEmail,tonyZeVat,tonyZePhone,tonyZeAddress,tonyZeCC);
    }

    @DisplayName("Check if method isSameEmail returns true when email is the same")
    @Test
    void shouldAssertTrueIsSameEmail() {
        EmailAddress test = new EmailAddress(VALIDEMAIL);
        assertTrue(validPerson.isSameEmail(test));
    }

    @DisplayName("Check if method isSameEmail returns false when email is not the same")
    @Test
    void shouldAssertFalseIsNotSameEmail() {
        EmailAddress test = new EmailAddress("tonyze@latinhater.pt");
        assertFalse(validPerson.isSameEmail(test));
    }

    @DisplayName("Valid Person Constructor Test")
    @Test
    void shouldNotThrowValidPersonConstructor(){
        assertNotNull(validPerson);
        assertDoesNotThrow (() ->  tonyZe = new Person (tonyZeName, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, tonyZeCC ));
    }




}