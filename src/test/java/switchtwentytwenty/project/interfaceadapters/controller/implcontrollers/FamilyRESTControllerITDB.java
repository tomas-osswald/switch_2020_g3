package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RunWith(SpringRunner.class)
@SpringBootTest
class FamilyRESTControllerITDB {
    AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
    AddFamilyAndSetAdminDTO invaliddto = new AddFamilyAndSetAdminDTO("tonyemail.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");


    @Autowired
    IFamilyRESTController familyRESTController;

    @Test
    void createFamilyAndSetAdmin() {

        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getFamily('@'+dto.getEmailID())).withSelfRel();

        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "tony@email.com", "tony@email.com", "12/12/2000");

        outputFamilyDTO.add(expectedLink);

        ResponseEntity<OutputFamilyDTO> expected = new ResponseEntity(outputFamilyDTO, HttpStatus.CREATED);

        ResponseEntity<OutputFamilyDTO> result = familyRESTController.createFamilyAndSetAdmin(dto);

        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertEquals(expected.getBody().toString(), result.getBody().toString());
    }

    @Test
    @DisplayName("CreateFamilyAndSetAdmin function success case")
    void createFamilyAndSetAdminSuccessCase() {
        AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("teste@hotmail.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getFamilyOptions('@'+dto.getEmailID())).withSelfRel();

        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "@teste@hotmail.com", "teste@hotmail.com", "12/12/2000");

        outputFamilyDTO.add(expectedLink);

        ResponseEntity expected = new ResponseEntity(outputFamilyDTO, HttpStatus.CREATED);

        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(dto);


        assertNotNull(result);
        assertEquals(HttpStatus.CREATED,result.getStatusCode());
        assertEquals(expected.getBody().toString(),result.getBody().toString());
    }

    @Test
    void testCreateFamilyAndSetAdmin() {
        ResponseEntity expected = new ResponseEntity("Error: This Email is not valid", HttpStatus.UNPROCESSABLE_ENTITY);
        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(invaliddto);

        assertEquals(expected, result);
    }

 /*   @Test
    void addRelationTest() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO();

        assertThrows(UnsupportedOperationException.class,()->familyRESTController.createRelation(createRelationDTO, "tony@email.com"));
    }*/

    @Test
    void getFamilyNameTest() {
        //String familyName = "Silva";
        assertThrows(UnsupportedOperationException.class,()->familyRESTController.getFamily("@tony@email.com"));
    }
}