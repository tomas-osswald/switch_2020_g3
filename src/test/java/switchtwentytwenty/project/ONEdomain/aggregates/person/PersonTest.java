package switchtwentytwenty.project.ONEdomain.aggregates.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.ONEdomain.valueobject.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final int VALIDADDRESSNUMBER = 69;
    final String VALIDBIRTHDATE = "01/03/1990";
    Person validPerson;
    Person tonyZe;
    Name tonyZeName;
    BirthDate tonyZeBirthDate;
    EmailAddress tonyZeEmail;
    VATNumber tonyZeVat;
    PhoneNumber tonyZePhone;
    Address tonyZeAddress;
    FamilyID familyID;

    @BeforeEach
    void createValidPerson() {
        Name tonyZeName = new Name(VALIDNAME);
        BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
        VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
        PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        validPerson = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);
    }

    @DisplayName("Check if method isSameEmail returns true when email is the same")
    @Test
    void shouldAssertTrueIsSameEmail() {
        PersonID test = new PersonID(VALIDEMAIL);
        assertTrue(validPerson.hasID(test));
    }

    @DisplayName("Check if method isSameEmail returns false when email is not the same")
    @Test
    void shouldAssertFalseIsNotSameEmail() {
        PersonID test = new PersonID("tonyze@latinhater.pt");
        assertFalse(validPerson.hasID(test));
    }

    @DisplayName("Valid Person Constructor Test")
    @Test
    void shouldNotThrowValidPersonConstructor() {
        assertNotNull(validPerson);
        Name tonyZeName = new Name(VALIDNAME);
        BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
        VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
        PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);

        FamilyID familyID = new FamilyID(UUID.randomUUID());
        assertDoesNotThrow(() -> tonyZe = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID));
    }


}