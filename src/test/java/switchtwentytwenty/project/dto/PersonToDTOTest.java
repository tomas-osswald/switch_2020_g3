package switchtwentytwenty.project.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonToDTOTest {



    Name name = new Name("TonyZe");
    BirthDate birthdate = new BirthDate("12/12/1970");
    PersonID personID = new PersonID("tonyze@gmail.com");
    VATNumber vat = new VATNumber(123456789);
    PhoneNumber phone = new PhoneNumber(null);
    FamilyID familyID = new FamilyID(UUID.randomUUID());
    String street = "Rua da amargura";
    String city = "Amadora";
    String zipCode = "4444-111";
    int number = 47;
    Address address = new Address(street, city, zipCode, number);

    PersonProfileDTO expected = new PersonProfileDTO();

    Person person = new Person(name, birthdate, personID, vat, phone, address, familyID);

    @Mock
    Person persona;

    @InjectMocks
    PersonToDTO personToDTO;



    @BeforeEach
    void setup() {
        expected.setId(person.id().toString());
        expected.setName(person.getName().toString());
        expected.setBirthdate(person.getBirthdate().toString());
        expected.setVat(person.getVat().toString());
        expected.setAddress(person.getAddress().toString());
        expected.setFamilyID(person.getFamilyID().toString());
    }

    @Test
    //@Ignore
    //TODO: esta jorda nao funciona
    void createPersonProfileDTOSuccess() {
    //  Mockito.doReturn(personID.toString()).when(persona).id().toString();
        Mockito.when(persona.id()).thenReturn(personID);
        Mockito.when(persona.getName()).thenReturn(name);
        Mockito.when(persona.getBirthdate()).thenReturn(birthdate);
        Mockito.when(persona.getVat()).thenReturn(vat);
        Mockito.when(persona.getAddress()).thenReturn(address);
        Mockito.when(persona.getFamilyID()).thenReturn(familyID);


        PersonProfileDTO result = personToDTO.createPersonProfileDTO(persona);

        Assertions.assertNotSame(expected, result);
        Assertions.assertEquals(expected, result);
    }
}