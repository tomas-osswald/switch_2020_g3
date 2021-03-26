package switchtwentytwenty.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateFamilyControllerTest {

    Application application;
    CreateFamilyController controller;
    CreateFamilyDTO VALIDCreateFamilyDTO;
    AddPersonDTO addPersonDTO;
    LocalDate localDate = LocalDate.of(2019,12,12);

    @BeforeEach
    void setup(){
        application = new Application();
        controller = new CreateFamilyController(application);
        VALIDCreateFamilyDTO = new CreateFamilyDTO( "Silva", LocalDate.of(2021,12,25) );
        addPersonDTO = new AddPersonDTO("email@there.com", "Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222", "139861572ZW2");
    }



    @DisplayName("Test if a family can be successfully created")
    @Test
    void shouldBeTrueCreateFamily() {
        assertTrue(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO));


    }



    @DisplayName("Test if a family isn't created if the admin email is already registered in the app")
    @Test
    void shouldBeFalseCreateFamilyEmailAlreadyregistered() {
        controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO);
        assertFalse(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO));
    }

    @DisplayName("Test if a family isn't created if the family name is null, void or empty")
    @ParameterizedTest
    @ValueSource(strings = {"   "})
    @NullAndEmptySource
    void shouldBeFalseCreateFamilyInvalidFamilyName(String value) {
        CreateFamilyDTO INVALIDCreateFamilyDTO = new CreateFamilyDTO(value, localDate);
        assertFalse(controller.createFamilyAndAdmin(INVALIDCreateFamilyDTO,addPersonDTO));
    }

}