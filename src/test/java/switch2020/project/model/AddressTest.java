package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    String street = "Rua dos aflitos";
    String postalCode = "4444-000";
    String local = "Zinde";
    String city = "Porto";

    /** Street **/
    @Test
    void NotCreateAddress_StreetNull() {
        assertThrows(IllegalArgumentException.class,()-> new Address(null, postalCode, local, city));
    }

    @Test
    void CreateAddress_StreetValid() {
        String rua = "Rua";
        Address address = new Address(rua, postalCode, local, city);
        assertTrue(address.validateStreet(street));
    }

    /** Postal Code **/
    @Test
    void NotCreateAddress_PostalCodeNull() {
        assertThrows(IllegalArgumentException.class,()->new Address(street, "", local, city));
    }

    @Test
    void NotCreateAddress_PostalCodeIncorrect() {
        assertThrows(IllegalArgumentException.class,()->new Address(street, "4444-55", local, city));
    }

    @Test
    void CreateAddress_PostalCodeValid() {
        String postal = "0000-111";
        Address address = new Address(street, postal, local, city);
        assertTrue(address.validatePostalCode(postal));
    }

    /** Local **/
    @Test
    void CreateAddress_LocalNull() {
        assertThrows(IllegalArgumentException.class,()-> new Address(street,postalCode,"",city));
    }

    @Test
    void CreateAddress_LocalValid() {
        String localid = "Maia";
        Address address = new Address(street, postalCode, localid, city);
        assertTrue(address.validateLocal(localid));
    }

    /** City **/
    @Test
    void CreateAddress_CityNull() {
        assertThrows(IllegalArgumentException.class,()-> new Address(street,postalCode,local,""));
    }

    @Test
    void CreateAddress_CityValid() {
        String cidade = "Lisboa";
        Address address = new Address(street, postalCode, local, cidade);
        assertTrue(address.validateCity(cidade));
    }
}