package switchtwentytwenty.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dataaccesslayer.CreateFamilyService;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddPersonControllerTest {

    Application application;
    AddPersonDTO addAdminPersonDTO;
    AddPersonDTO addPersonDTO;
    AddPersonController addPersonController;

    @BeforeEach
    void setAdmin() {
        application = new Application();
        addAdminPersonDTO = new AddPersonDTO("email@there.com", "Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222", "139861572ZW2");
        addPersonDTO = new AddPersonDTO("email2@there.com", "Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222", "139861572ZW2");
        addPersonController = new AddPersonController(application);

        CreateFamilyDTO createFamilyDTO = new CreateFamilyDTO( "Silva",null);
        CreateFamilyService createFamilyService = new CreateFamilyService(createFamilyDTO, addAdminPersonDTO, application);

        createFamilyService.createFamilyAndAddAdmin();
    }

    @DisplayName("Successfully add a person")
    @Test
    void mustReturnTrueAddPerson() {
        application.logInAsAdmin();

        assertTrue(addPersonController.addPerson(addPersonDTO));
    }

    @DisplayName("Unsuccessfully add a person - not the admin")
    @Test
    void mustReturnFalseAddPersonNotAdmin() {
        application.logInAsNotAdmin();

        assertFalse(addPersonController.addPerson(addPersonDTO));
    }


    @DisplayName("Unsuccessfully add a person - email already registered")
    @Test
    void mustReturnFalseAddPersonEmailRegistred() {
        application.logInAsAdmin();

        addPersonController.addPerson(addPersonDTO);
        assertFalse(addPersonController.addPerson(addPersonDTO));
    }


}