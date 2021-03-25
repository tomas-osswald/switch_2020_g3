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
    AddPersonDTO addPersonDTO;
    AddPersonController addPersonController;

    @BeforeEach
    void setAdmin() {
        application = new Application();

        CreateFamilyDTO createFamilyDTO = new CreateFamilyDTO("tonyze@hotmail.com", "Silva", "Tony", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");
        CreateFamilyService createFamilyService = new CreateFamilyService(createFamilyDTO, application);
        addPersonDTO = new AddPersonDTO("email@there.com", "Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222", "139861572ZW2");
        addPersonController = new AddPersonController(application);

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

        AddPersonDTO addPersonDTO2 = new AddPersonDTO("email@there.com", "Luis", "28/13/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222", "139861572ZW2");

        addPersonController.addPerson(addPersonDTO2);
        assertFalse(addPersonController.addPerson(addPersonDTO));
    }


}