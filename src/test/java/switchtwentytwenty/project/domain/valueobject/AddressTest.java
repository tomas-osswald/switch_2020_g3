package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {

    @Test
    void testToString() {
        String street = "Rua da Amargura";
        String city = "Porto";
        String zipCode = "4405-586";
        Address address = new Address(street, city, zipCode, 14);
        String expected = "Rua da Amargura&Porto&4405-586&14";
        String result = address.toString();
        assertEquals(expected, result);

    }
}