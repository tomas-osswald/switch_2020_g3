package switchtwentytwenty.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateFamilyControllerTest {

    Application application;
    CreateFamilyController controller;
    CreateFamilyDTO VALIDCreateFamilyDTO;

    @BeforeEach
    void setup(){
        application = new Application();
        controller = new CreateFamilyController(application);
        VALIDCreateFamilyDTO = new CreateFamilyDTO("tonyze@hotmail.com", "Silva", "Tony", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");

    }

    @DisplayName("Test if a family can be successfully created")
    @Test
    void shouldBeTrueCreateFamily() {
        assertTrue(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO));
    }

    @DisplayName("Test if a family isn't created if the admin email is already registered in the app")
    @Test
    void shouldBeFalseCreateFamilyEmailAlreadyregistered() {
        controller.createFamilyAndAdmin(VALIDCreateFamilyDTO);
        assertFalse(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO));
    }

    @DisplayName("Test if a family isn't created if the family name is null, void or empty")
    @ParameterizedTest
    @ValueSource(strings = {"   "})
    @NullAndEmptySource
    void shouldBeFalseCreateFamilyInvalidFamilyName(String value) {
        CreateFamilyDTO INVALIDCreateFamilyDTO = new CreateFamilyDTO("tonyze@hotmail.com", value, "Tony", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");
        assertFalse(controller.createFamilyAndAdmin(INVALIDCreateFamilyDTO));
    }

}