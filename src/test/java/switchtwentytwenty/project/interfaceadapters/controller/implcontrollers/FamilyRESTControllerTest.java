package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.AddRelationDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyRESTControllerTest {
    AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
    AddFamilyAndSetAdminDTO invaliddto = new AddFamilyAndSetAdminDTO("tonyemail.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

    @Autowired
    IFamilyRESTController familyRESTController;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        // We can create mock based on the Interface or a Class
        // templateEngine = mock(TemplateEngine.class);

        // init mock with annotations
        //MockitoAnnotations.initMocks(this);

        // just another version of initilization of mocks with annotation
        // pay attention to tear down method - we have to call close method
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("CreateFamilyAndSetAdmin function success case")
    void createFamilyAndSetAdmin() {
        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getFamilyName(dto.getFamilyName())).withSelfRel();

        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "@tony@email.com", "tony@email.com", "12/12/2000");

        outputFamilyDTO.add(expectedLink);

        ResponseEntity expected = new ResponseEntity(outputFamilyDTO, HttpStatus.CREATED);

        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(dto);


        assertNotNull(result);
        assertEquals(result.getStatusCode(),HttpStatus.CREATED);
        //assertEquals(result,expected);
    }

    @Test
    void testCreateFamilyAndSetAdmin() {
        ResponseEntity expected = new ResponseEntity("Business Error Api Logic", HttpStatus.UNPROCESSABLE_ENTITY);
        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(invaliddto);

        assertEquals(expected, result);
    }

    @Test
    void familiesOptionsTest() {
        Link link =  linkTo(FamilyRESTController.class).withRel("Add New Family");
        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        ResponseEntity<Object> expected = new ResponseEntity<>(link,header,HttpStatus.OK);
        ResponseEntity<Object> result = familyRESTController.familiesOptions();

        assertEquals(result,expected);
    }

    @Test
    void addRelationTest() {
        AddRelationDTO addRelationDTO = new AddRelationDTO();

        assertThrows(UnsupportedOperationException.class,()->familyRESTController.addRelation(addRelationDTO));
    }

    @Test
    void getFamilyNameTest() {
        String familyName = "Silva";

        assertThrows(UnsupportedOperationException.class,()->familyRESTController.getFamilyName(familyName));
    }
}