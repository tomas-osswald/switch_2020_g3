package switchtwentytwenty.project.datamodel;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberJPATest {

    int phoneNumber = 963369963;

    String id = "email@email.com";
    PersonIDJPA personIDJPA = new PersonIDJPA(id);

    String name = "TonyZe";
    String birthdate = "23/12/1992";
    Integer vat = 999999999;

    FamilyIDJPA familyIDJPA = new FamilyIDJPA(UUID.randomUUID().toString());
    PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, familyIDJPA);

    @Test
    void getIdTest() {
        Long expected = Long.valueOf(0);

        PhoneNumberJPA phoneNumberJPA = new PhoneNumberJPA(phoneNumber, personJPA);

        Long result = phoneNumberJPA.getId();

        assertEquals(expected, result);
    }

    @Test
    void getPhoneNumberTest() {
        int expected = 963369963;

        PhoneNumberJPA phoneNumberJPA = new PhoneNumberJPA(phoneNumber, personJPA);

        int result = phoneNumberJPA.getNumber();

        assertEquals(expected, result);
    }

    @Test
    void testEqualsSameObject() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);
        PhoneNumberJPA phoneNumberJPATwo = phoneNumberJPAOne;

        assertEquals(phoneNumberJPAOne,phoneNumberJPATwo);
    }

    @Test
    void testEqualsNotSameObject() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);
        PhoneNumberJPA phoneNumberJPATwo = new PhoneNumberJPA(phoneNumber, personJPA);

        assertEquals(phoneNumberJPAOne,phoneNumberJPATwo);
        assertNotSame(phoneNumberJPAOne,phoneNumberJPATwo);
    }

    @Test
    void testEqualsDifferentTypeOfObject() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);

        assertNotEquals(phoneNumberJPAOne,personJPA);
    }

    @Test
    void testEqualsNotEqual() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);
        int otherPhoneNumber = 147741147;
        PhoneNumberJPA phoneNumberJPATwo = new PhoneNumberJPA(otherPhoneNumber, personJPA);

        assertNotEquals(phoneNumberJPAOne,phoneNumberJPATwo);
    }


    @Test
    void testHashCodeEqualObjects() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);
        PhoneNumberJPA phoneNumberJPATwo = new PhoneNumberJPA(phoneNumber, personJPA);

        assertEquals(phoneNumberJPAOne.hashCode(),phoneNumberJPATwo.hashCode());
        assertNotSame(phoneNumberJPAOne,phoneNumberJPATwo);
    }

    @Test
    void testHashCodeDifferentObjects() {
        PhoneNumberJPA phoneNumberJPAOne = new PhoneNumberJPA(phoneNumber, personJPA);
        int otherPhoneNumber = 147741147;
        PhoneNumberJPA phoneNumberJPATwo = new PhoneNumberJPA(otherPhoneNumber, personJPA);


        assertNotEquals(phoneNumberJPAOne.hashCode(),phoneNumberJPATwo.hashCode());
    }

}