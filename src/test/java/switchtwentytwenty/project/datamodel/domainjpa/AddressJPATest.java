package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AddressJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddressJPATest {

    String street = "Rua";
    String city = "Covilândia";
    String zip = "6215-000";
    String doorNumber = "1";

    String id = "emaiil@email.com";
    PersonIDJPA personIDJPA = new PersonIDJPA(id);

    String name = "TonyZe";
    String birthdate = "23/12/1992";
    Integer vat = 999999999;

    FamilyIDJPA familyIDJPA = new FamilyIDJPA(UUID.randomUUID().toString());
    PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, familyIDJPA);


    @Test
    @Tag("US010")
    void getId() {
        Long expected = Long.valueOf(0);

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        Long result = addressJPA.getId();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void getStreet() {
        String expected = "Rua";

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        String result = addressJPA.getStreet();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void getCity() {
        String expected = "Covilândia";

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        String result = addressJPA.getCity();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void getZipCode() {
        String expected = "6215-000";

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        String result = addressJPA.getZipCode();

        assertEquals(expected, result);
    }

    @Test
    @Tag("US010")
    void getDoorNumber() {
        String expected = "1";

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        String result = addressJPA.getDoorNumber();

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

        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        PersonJPA result = addressJPA.getPerson();

        assertEquals(expected, result);
    }


    @Test
    @Tag("US010")
    void testEquals() {
        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        assertEquals(addressJPA, addressJPA);
    }

    @Test
    @Tag("US010")
    void testEqualsTwo() {
        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        AddressJPA addressJPATwo = new AddressJPA(street, city, zip, doorNumber, personJPA);

        assertEquals(addressJPA, addressJPATwo);
    }

    @Test
    @Tag("US010")
    void hashCodeSameEqualObjects() {
        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        AddressJPA addressJPATwo = new AddressJPA(street, city, zip, doorNumber, personJPA);

        assertEquals(addressJPA.hashCode(), addressJPATwo.hashCode());
        assertNotSame(addressJPA, addressJPATwo);
    }

    @Test
    @Tag("US010")
    void hashCodeDifferentObjects() {
        AddressJPA addressJPA = new AddressJPA(street, city, zip, doorNumber, personJPA);

        AddressJPA addressJPATwo = new AddressJPA("street", "city", "zip", "doorNumber", personJPA);

        assertNotEquals(addressJPA.hashCode(), addressJPATwo.hashCode());
    }

}