package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.image.ImageWatched;
import switchtwentytwenty.project.dto.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.FamilyOutputDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyRESTControllerTest {
    AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("tony@email.com","Silva","12/12/1222",999999999,919999999,"Rua","Cidade","12B","4400-123","Silva","12/12/2000");


    @Autowired
    IFamilyRESTController familyRESTController;

    @Disabled
    @Test
    void createFamilyAndSetAdmin() {

        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getFamilyName(dto.getFamilyName())).withSelfRel();

        FamilyOutputDTO familyOutputDTO = new FamilyOutputDTO("Silva", "tony@email.com", "tony@email.com");

        familyOutputDTO.add(expectedLink);

        ResponseEntity expected = new ResponseEntity(familyOutputDTO, HttpStatus.CREATED);

        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(dto);

        assertEquals(expected,result);
    }
}