package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRESTControllerIntegrationTestITDB {

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
    AddEmailDTO emailToAddDTO = new AddEmailDTO(adminID.toString(), emailToAdd);


    @Test
    @Disabled
    @DisplayName("Success case in adding email using integration test with all components")
    void addEmailToFamilyMemberExpectingSuccess() {
        OutputEmailDTO expectedOutputEmailDTO = new OutputEmailDTO(emailToAdd, addedEmailID);

        Link expectedLink = linkTo(methodOn(PersonRESTController.class).getEmail(adminEmail, addedEmailID)).withSelfRel();
        expectedOutputEmailDTO.add(expectedLink);

        ResponseEntity<Object> expected = new ResponseEntity<>(expectedOutputEmailDTO, HttpStatus.OK);

        ResponseEntity<Object> result = personRESTController.addEmail(emailToAddDTO);

        assertEquals(expected, result);
    }

}
