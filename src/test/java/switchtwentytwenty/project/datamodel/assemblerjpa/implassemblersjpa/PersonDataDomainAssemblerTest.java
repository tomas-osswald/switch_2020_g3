package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.domainjpa.*;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonDataDomainAssemblerTest {

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final String VALIDADDRESSNUMBER = "69";
    final String VALIDBIRTHDATE = "01/03/1990";

    final String ANOTHERVALIDEMAIL = "anotheremail@here.com";

    Name tonyZeName;
    BirthDate tonyZeBirthDate;
    PersonID tonyZeEmail;
    VATNumber tonyZeVat;
    PhoneNumber tonyZePhone;
    Address tonyZeAddress;
    FamilyID familyID;
    EmailAddress emailAddress;

    @Autowired
    PersonDataDomainAssembler personDataDomainAssembler;

    @BeforeEach
    void createValidPerson() {
        tonyZeName = new Name(VALIDNAME);
        tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        tonyZeEmail = new PersonID(VALIDEMAIL);
        tonyZeVat = new VATNumber(VALIDVATNUMBER);
        tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        familyID = new FamilyID(VALIDEMAIL);

        emailAddress = new EmailAddress(ANOTHERVALIDEMAIL);
    }


    @Test
    void toDataComparingEquals() {
        Person person = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);
        person.addEmail(emailAddress);

        PersonJPA expected = new PersonJPA(new PersonIDJPA(VALIDEMAIL), VALIDNAME, VALIDBIRTHDATE, VALIDVATNUMBER, new FamilyIDJPA(VALIDEMAIL));

        PersonJPA result = personDataDomainAssembler.toData(person);


        assertEquals(expected, result);
    }

    @Test
    void toDataComparingByAttribute() {
        Person person = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);
        person.addEmail(emailAddress);

        PersonJPA expected = new PersonJPA(new PersonIDJPA(VALIDEMAIL), VALIDNAME, VALIDBIRTHDATE, VALIDVATNUMBER, new FamilyIDJPA(VALIDEMAIL));

        PersonJPA result = personDataDomainAssembler.toData(person);


        PersonIDJPA expectedPersonIDJPA = new PersonIDJPA(VALIDEMAIL);
        PersonIDJPA resultPersonIDJPA = result.getId();

        String exepctedName = VALIDNAME;
        String resultName = result.getName();

        List<EmailAddressJPA> expectedEmails = new ArrayList<>();
        expectedEmails.add(new EmailAddressJPA(ANOTHERVALIDEMAIL, expected));
        List<EmailAddressJPA> resultEmail = result.getEmails();

        List<PhoneNumberJPA> expectedPhone = new ArrayList<>();
        expectedPhone.add(new PhoneNumberJPA(VALIDPHONENUMBER, expected));

        List<PhoneNumberJPA> resultPhones = result.getPhones();

        Integer expectedVat = VALIDVATNUMBER;
        Integer resultVat = result.getVat();

        AddressJPA expectedAddress = new AddressJPA(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER, expected);
        AddressJPA resultAddressJPA = result.getAddress();

        FamilyIDJPA expectedFamilyIDJPA = new FamilyIDJPA("@" + VALIDEMAIL);
        FamilyIDJPA resultFamilyIDJPA = result.getFamilyid();

        assertEquals(expected, result);

        assertEquals(expectedPersonIDJPA, resultPersonIDJPA);
        assertEquals(exepctedName, resultName);
        assertEquals(expectedEmails, resultEmail);
        assertEquals(expectedVat, resultVat);
        assertEquals(expectedAddress, resultAddressJPA);
        assertEquals(expectedFamilyIDJPA, resultFamilyIDJPA);
        assertEquals(expectedPhone, resultPhones);
        assert(!resultEmail.isEmpty());
        assert(!resultPhones.isEmpty());
    }



    @Test
    void createAddress() {
    }

    @Test
    void createPhoneNumberList() {
    }

    @Test
    void createEmailAdressList() {
    }

    @Test
    void createVATNumber() {
    }

    @Test
    void createPersonID() {
    }

    @Test
    void createName() {
    }

    @Test
    void createBirthDate() {
    }

    @Test
    void createFamilyID() {
    }
}