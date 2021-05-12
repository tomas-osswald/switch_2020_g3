package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EmailAddressJPATest {

    String email = "email@email.com";

    String id = "emaiil@email.com";
    PersonIDJPA personIDJPA = new PersonIDJPA(id);

    String name = "TonyZe";
    String birthdate = "23/12/1992";
    Integer vat = 999999999;

    FamilyIDJPA familyIDJPA = new FamilyIDJPA(UUID.randomUUID().toString());
    PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, familyIDJPA);


    @Test
    @Tag("US010")
    void getEmail() {
        String expected = "email@email.com";

        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        String result = emailAddressJPA.getEmail();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void getId() {
        Long expected = Long.valueOf(1);

        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);
        emailAddressJPA.setId(1L);

        Long result = emailAddressJPA.getId();

        assertEquals(expected, result);
        assertNotEquals(0L, result);
    }

    @Test
    @Tag("US010")
    void getPerson() {
        String id = "emaiil@email.com";
        PersonIDJPA personIDJPA = new PersonIDJPA(id);

        String name = "TonyZe";
        String birthdate = "23/12/1992";
        Integer vat = 999999999;

        PersonJPA expected = new PersonJPA(personIDJPA, name, birthdate, vat, familyIDJPA);

        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);
        PersonJPA result = emailAddressJPA.getPerson();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void equalsTestSameEmailAddressJPA() {
        EmailAddressJPA emailAddressJPAOne = new EmailAddressJPA(email, personJPA);
        EmailAddressJPA emailAddressJPATwo = emailAddressJPAOne;

        assertEquals(emailAddressJPAOne, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void equalsTestEqualEmailAddressJPAs() {
        EmailAddressJPA emailAddressJPAOne = new EmailAddressJPA(email, personJPA);
        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA(email, personJPA);

        assertEquals(emailAddressJPAOne, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void equalsTestDifferentEmailAddressJPAs() {
        EmailAddressJPA emailAddressJPAOne = new EmailAddressJPA(email, personJPA);
        String otherEmail = "test@hotmail.com";
        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA(otherEmail, personJPA);

        assertNotEquals(emailAddressJPAOne, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void equalsTestDifferentObjects() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);
        String notEmailAddressJPA = "test@hotmail.com";

        assertNotEquals(emailAddressJPA, notEmailAddressJPA);
    }

    @Test
    @Tag("US010")
    void equalsTestDifferentFromNull() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);
        String nullString = null;

        assertNotEquals(emailAddressJPA, nullString);
    }

    @Test
    @Tag("US010")
    void hashCodeEqualObjects() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA(email, personJPA);

        assertEquals(emailAddressJPA.hashCode(), emailAddressJPATwo.hashCode());
        assertNotSame(emailAddressJPA, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void hashCodeDifferentObjects() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA("email", personJPA);

        assertNotEquals(emailAddressJPA.hashCode(), emailAddressJPATwo.hashCode());
    }


}