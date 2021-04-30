package switchtwentytwenty.project.datamodel;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.*;

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
        Long expected = Long.valueOf(0);

        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        Long result = emailAddressJPA.getId();

        assertEquals(expected, result);
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
    void testEquals() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        assertEquals(emailAddressJPA, emailAddressJPA);
    }

    @Test
    @Tag("US010")
    void testEqualsTwo() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA(email, personJPA);

        assertEquals(emailAddressJPA, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void hashCodeEqualObjects() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA(email, personJPA);

        assertEquals(emailAddressJPA, emailAddressJPATwo);
        assertNotSame(emailAddressJPA, emailAddressJPATwo);
    }

    @Test
    @Tag("US010")
    void hashCodeDifferentObjects() {
        EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email, personJPA);

        EmailAddressJPA emailAddressJPATwo = new EmailAddressJPA("email", personJPA);

        assertNotEquals(emailAddressJPA, emailAddressJPATwo);
    }



}