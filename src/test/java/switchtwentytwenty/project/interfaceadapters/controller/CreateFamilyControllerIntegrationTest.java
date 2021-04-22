package switchtwentytwenty.project.interfaceadapters.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.ImplControllers.CreateFamilyController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyControllerIntegrationTest {

    CreateFamilyController controller;
    @Autowired
    ICreateFamilyService createFamilyService;
    InputFamilyDTO VALIDCreateFamilyDTO;
    InputPersonDTO inputPersonDTO;

    @BeforeEach
    void setup(){
        controller = new CreateFamilyController(createFamilyService);
        VALIDCreateFamilyDTO = new InputFamilyDTO( "Silva", "2019/12/12" );
        inputPersonDTO = new InputPersonDTO("email@there.com", "email@here.com","Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", "12", "4432-222");
    }



    @DisplayName("Test if a family can be successfully created")
    @Test
    void shouldBeTrueCreateFamily() {

        assertTrue(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO, inputPersonDTO));


    }

    @DisplayName("Test if a family isn't created if the admin email is already registered in the app")
    @Test
    void shouldBeFalseCreateFamilyEmailAlreadyregistered() {
        controller.createFamilyAndAdmin(VALIDCreateFamilyDTO, inputPersonDTO);
        assertFalse(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO, inputPersonDTO));
    }

    @DisplayName("Test if a family isn't created if the family name is null, void or empty")
    @ParameterizedTest
    @ValueSource(strings = {"   "})
    @NullAndEmptySource
    void shouldBeFalseCreateFamilyInvalidFamilyName(String value) {
        InputFamilyDTO INVALIDCreateFamilyDTO = new InputFamilyDTO(value, "2019/12/12");
        assertFalse(controller.createFamilyAndAdmin(INVALIDCreateFamilyDTO, inputPersonDTO));
    }

}