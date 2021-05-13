package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRESTControllerITDB {

    @Autowired
    IPersonRESTController personRESTController;

    //TonyZe data
    String adminEmail = "tonyze@latinlover.com";
    PersonID adminID = new PersonID(adminEmail);
    Name name = new Name("tonyZe");
    BirthDate birthDate = new BirthDate("01/01/1970");
    VATNumber vatNumber = new VATNumber(333333333);
    FamilyID familyID = new FamilyID(adminEmail);
    Person tonyZe = new Person(adminID, name, birthDate, vatNumber, familyID);

    String emailToAdd = "tonynovomail@tvtel.com";
    String addedEmailID = "3L";
    AddEmailDTO emailToAddDTO = new AddEmailDTO(emailToAdd);

    @Test
    void peopleOptions() {

        OptionsDTO optionsDTO = new OptionsDTO();
        Link linkToPeopleOptions = linkTo(methodOn(PersonRESTController.class).peopleOptions()).withSelfRel();
        Link linkToPOST = linkTo(methodOn(PersonRESTController.class).addFamilyMember(new AddFamilyMemberDTO())).withRel("POST - Add Family Member");
        optionsDTO.add(linkToPeopleOptions);
        optionsDTO.add(linkToPOST);
        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        ResponseEntity expected = new ResponseEntity(optionsDTO, header, HttpStatus.OK);

        ResponseEntity result = personRESTController.peopleOptions();

        assertEquals(expected, result);
        assertNotNull(result.getHeaders());
    }
    @Test
    @DisplayName("Success case in adding email using integration test with all components")
    void addEmailToFamilyMemberExpectingSuccess() {
        OutputEmailDTO expectedOutputEmailDTO = new OutputEmailDTO(emailToAdd);

        Link expectedLink = linkTo(methodOn(PersonRESTController.class).getProfileInfo(adminEmail)).withSelfRel();
        expectedOutputEmailDTO.add(expectedLink);

        ResponseEntity<Object> expected = new ResponseEntity<>(expectedOutputEmailDTO, HttpStatus.OK);

        ResponseEntity<Object> result = personRESTController.addEmail(emailToAddDTO, adminID.toString());

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Integration Test for Successfully adding a new Family Member")
    void addFamilyMemberSuccessIT() {
        List<Integer> phones = new ArrayList<>();
        phones.add(919999999);
        List<String> emails = new ArrayList<>();
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        expectedOutputPersonDTO.setName("Kiko");
        expectedOutputPersonDTO.setId("kiko@gmail.com");
        expectedOutputPersonDTO.setBirthdate("12/12/1222");
        expectedOutputPersonDTO.setVat("123456789");
        expectedOutputPersonDTO.setStreet("rua");
        expectedOutputPersonDTO.setCity("cidade");
        expectedOutputPersonDTO.setZipCode("1234-123");
        expectedOutputPersonDTO.setDoorNumber("69");
        expectedOutputPersonDTO.setFamilyID("@tonyze@latinlover.com");
        expectedOutputPersonDTO.setPhoneNumbers(phones);
        expectedOutputPersonDTO.setEmails(emails);
        Link personOptionsLink = linkTo(methodOn(PersonRESTController.class).personOptions(expectedOutputPersonDTO.getId())).withRel("Person Options");
        expectedOutputPersonDTO.add(personOptionsLink);
        ResponseEntity expected = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.CREATED);

        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();
        addFamilyMemberDTO.setAdminID("tonyze@latinlover.com");
        addFamilyMemberDTO.setEmailID("kiko@gmail.com");
        addFamilyMemberDTO.setName("Kiko");
        addFamilyMemberDTO.setBirthDate("12/12/1222");
        addFamilyMemberDTO.setVatNumber(123456789);
        addFamilyMemberDTO.setPhone(919999999);
        addFamilyMemberDTO.setStreet("rua");
        addFamilyMemberDTO.setCity("cidade");
        addFamilyMemberDTO.setHouseNumber("69");
        addFamilyMemberDTO.setZipCode("1234-123");
        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        assertEquals(expected.getBody(), result.getBody());
        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertNotSame(expected, result);


    }
    @Test
    @DisplayName("Integration Test for failure in adding a new Family Member: User is already Registered")
    void addFamilyMemberFailureAlreadyRegisteredIT() {

        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();
        addFamilyMemberDTO.setAdminID("tonyze@latinlover.com");
        addFamilyMemberDTO.setEmailID("kvanessa@latina.com");
        addFamilyMemberDTO.setName("Kiko");
        addFamilyMemberDTO.setBirthDate("12/12/1222");
        addFamilyMemberDTO.setVatNumber(123456789);
        addFamilyMemberDTO.setPhone(919999999);
        addFamilyMemberDTO.setStreet("rua");
        addFamilyMemberDTO.setCity("cidade");
        addFamilyMemberDTO.setHouseNumber("69");
        addFamilyMemberDTO.setZipCode("1234-123");
        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        ResponseEntity expected = new ResponseEntity(HttpStatus.BAD_REQUEST);

        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertNotSame(expected, result);


    }

    @Test
    @DisplayName("Integration Test for failure in adding a new Family Member: User is not admin")
    void addFamilyMemberFailureNotAdminIT() {

        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();
        addFamilyMemberDTO.setAdminID("notadmin@latinlover.com");
        addFamilyMemberDTO.setEmailID("kiko@gmail.com");
        addFamilyMemberDTO.setName("Kiko");
        addFamilyMemberDTO.setBirthDate("12/12/1222");
        addFamilyMemberDTO.setVatNumber(123456789);
        addFamilyMemberDTO.setPhone(919999999);
        addFamilyMemberDTO.setStreet("rua");
        addFamilyMemberDTO.setCity("cidade");
        addFamilyMemberDTO.setHouseNumber("69");
        addFamilyMemberDTO.setZipCode("1234-123");
        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        ResponseEntity expected = new ResponseEntity(HttpStatus.BAD_REQUEST);

        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertNotSame(expected, result);


    }

    @Test
    @DisplayName("Integration Test for Catching an Unprocessable Entity Exception")
    void addFamilyMemberFailureExceptionIT() {

        ResponseEntity expected = new ResponseEntity(HttpStatus.BAD_REQUEST);

        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();
        addFamilyMemberDTO.setAdminID("tonyze@latinlover.com");
        addFamilyMemberDTO.setEmailID("kiko@@@@@gmail.com");
        addFamilyMemberDTO.setName("Kiko");
        addFamilyMemberDTO.setBirthDate("12/12/1222");
        addFamilyMemberDTO.setVatNumber(123456789);
        addFamilyMemberDTO.setPhone(919999999);
        addFamilyMemberDTO.setStreet("rua");
        addFamilyMemberDTO.setCity("cidade");
        addFamilyMemberDTO.setHouseNumber("69");
        addFamilyMemberDTO.setZipCode("1234-123");
        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);


        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertNotSame(expected, result);


    }

    @Test
    @DisplayName("Integration Test for comparing wrong response links")
    void addFamilyMemberFailureIT() {
        List<Integer> phones = new ArrayList<>();
        phones.add(919999999);
        List<String> emails = new ArrayList<>();
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        expectedOutputPersonDTO.setName("Kiko");
        expectedOutputPersonDTO.setId("kiko@gmail.com");
        expectedOutputPersonDTO.setBirthdate("12/12/1222");
        expectedOutputPersonDTO.setVat("123456789");
        expectedOutputPersonDTO.setStreet("rua");
        expectedOutputPersonDTO.setCity("cidade");
        expectedOutputPersonDTO.setZipCode("1234-123");
        expectedOutputPersonDTO.setDoorNumber("69");
        expectedOutputPersonDTO.setFamilyID("@tonyze@latinlover.com");
        expectedOutputPersonDTO.setPhoneNumbers(phones);
        expectedOutputPersonDTO.setEmails(emails);
        Link personOptionsLink = linkTo(methodOn(PersonRESTController.class).personOptions(expectedOutputPersonDTO.getId())).withRel("PersonvgfdshabjnkmOptions");
        expectedOutputPersonDTO.add(personOptionsLink);
        ResponseEntity expected = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.CREATED);

        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();
        addFamilyMemberDTO.setAdminID("tonyze@latinlover.com");
        addFamilyMemberDTO.setEmailID("kiko0@gmail.com");
        addFamilyMemberDTO.setName("Kiko");
        addFamilyMemberDTO.setBirthDate("12/12/1222");
        addFamilyMemberDTO.setVatNumber(123456789);
        addFamilyMemberDTO.setPhone(919999999);
        addFamilyMemberDTO.setStreet("rua");
        addFamilyMemberDTO.setCity("cidade");
        addFamilyMemberDTO.setHouseNumber("69");
        addFamilyMemberDTO.setZipCode("1234-123");
        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        assertNotEquals(expected.getBody(), result.getBody());
        assertEquals(expected.getStatusCode(), result.getStatusCode());


    }

}
