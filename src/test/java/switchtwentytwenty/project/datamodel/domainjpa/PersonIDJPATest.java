package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;

import static org.junit.jupiter.api.Assertions.*;

class PersonIDJPATest {

    String personID = "email@email.com";

    @Tag("US010")
    @Test
    void getPersonId() {
        String expected = "email@email.com";

        PersonIDJPA personIDJPA = new PersonIDJPA(personID);

        String result = personIDJPA.toString();

        assertEquals(expected, result);
    }

    @Tag("US010")
    @Test
    void sameEquals() {
        PersonIDJPA personIDJPA = new PersonIDJPA(personID);

        assertEquals(personIDJPA, personIDJPA);
    }
}