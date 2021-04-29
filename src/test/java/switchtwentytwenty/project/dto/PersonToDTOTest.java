package switchtwentytwenty.project.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonToDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonToDTOTest {


    Name name = new Name("TonyZe");
    BirthDate birthdate = new BirthDate("12/12/1970");
    PersonID personID = new PersonID("tonyze@gmail.com");
    VATNumber vat = new VATNumber(123456789);
    FamilyID familyID = new FamilyID("tonyze@gmail.com");
    String street = "Rua da amargura";
    String city = "Amadora";
    String zipCode = "4444-111";
    String doorNumber = "47";
    Address address = new Address(street, city, zipCode, doorNumber);


    @Mock
    Person person;

    @Mock
    List<String> mockPhoneNumbers;

    @InjectMocks
    PersonToDTO personToDTO;


    @Test
    @DisplayName("Should return a not null PersonDataDTO")
    void createPersonProfileDTOSuccess() {
        Mockito.when(person.id()).thenReturn(personID);
        Mockito.when(person.getName()).thenReturn(name);
        Mockito.when(person.getBirthdate()).thenReturn(birthdate);
        Mockito.when(person.getVat()).thenReturn(vat);
        Mockito.when(person.getAddress()).thenReturn(address);
        Mockito.when(person.getFamilyID()).thenReturn(familyID);


        OutputPersonDTO result = personToDTO.createPersonProfileDTO(person);

        Assertions.assertNotNull(result);
    }

    /*
    @Test
    @DisplayName("Should return a DTO with PhoneNumbers in string format")
    void phoneNumberListInStringFormat(){
        PhoneNumber number1 = new PhoneNumber(919999999);
        PhoneNumber number2 = new PhoneNumber(918888888);
        List<PhoneNumber> phoneNumbers = new ArrayList();
        phoneNumbers.add(number1);
        phoneNumbers.add(number2);

        Mockito.when(person.id()).thenReturn(personID);
        Mockito.when(person.getName()).thenReturn(name);
        Mockito.when(person.getBirthdate()).thenReturn(birthdate);
        Mockito.when(person.getVat()).thenReturn(vat);
        Mockito.when(person.getAddress()).thenReturn(address);
        Mockito.when(person.getFamilyID()).thenReturn(familyID);
        Mockito.when(person.getPhoneNumbers()).thenReturn(phoneNumbers);

        PersonProfileDTO result = personToDTO.createPersonProfileDTO(person);



        Assertions.assertEquals(result.getPhoneNumbers(),mockPhoneNumbers);
    }

     */



    @Test
    @DisplayName("Should return a not null PersonDataDTO with a phone number list")
    void createPersonProfileDTOSuccessTestPhoneNumbers() {
        PhoneNumber number1 = new PhoneNumber(919999999);
        PhoneNumber number2 = new PhoneNumber(918888888);
        List<PhoneNumber> phoneNumbers = new ArrayList();
        phoneNumbers.add(number1);
        phoneNumbers.add(number2);

        Mockito.when(person.id()).thenReturn(personID);
        Mockito.when(person.getName()).thenReturn(name);
        Mockito.when(person.getBirthdate()).thenReturn(birthdate);
        Mockito.when(person.getVat()).thenReturn(vat);
        Mockito.when(person.getAddress()).thenReturn(address);
        Mockito.when(person.getFamilyID()).thenReturn(familyID);
        Mockito.when(person.getPhoneNumbers()).thenReturn(phoneNumbers);

        List<String> expected = new ArrayList<>();
        expected.add("919999999");
        expected.add("918888888");

        OutputPersonDTO result = personToDTO.createPersonProfileDTO(person);

        Assertions.assertEquals(expected, result.getPhoneNumbers());
    }

    @Test
    @DisplayName("Should return a not null PersonDataDTO with an EmailAddress list")
    void createPersonProfileDTOSuccessTestEmailAddress() {
        EmailAddress email1 = new EmailAddress("email1@email.com");
        EmailAddress email2 = new EmailAddress("email2@email.com");
        List<EmailAddress> emailAddressList = new ArrayList();
        emailAddressList.add(email1);
        emailAddressList.add(email2);

        Mockito.when(person.id()).thenReturn(personID);
        Mockito.when(person.getName()).thenReturn(name);
        Mockito.when(person.getBirthdate()).thenReturn(birthdate);
        Mockito.when(person.getVat()).thenReturn(vat);
        Mockito.when(person.getAddress()).thenReturn(address);
        Mockito.when(person.getFamilyID()).thenReturn(familyID);
        Mockito.when(person.getEmails()).thenReturn(emailAddressList);

        List<String> expected = new ArrayList<>();
        expected.add("email1@email.com");
        expected.add("email2@email.com");

        OutputPersonDTO result = personToDTO.createPersonProfileDTO(person);

        Assertions.assertEquals(expected, result.getEmails());
    }

}