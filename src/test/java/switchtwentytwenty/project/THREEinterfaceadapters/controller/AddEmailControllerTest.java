package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.Application;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailControllerTest {

    Application application;
    CreateFamilyController createFamilyController;
    AddEmailController addEmailController;
    AddFamilyMemberController addFamilyMemberController;
    String adminEmail = "tonyze@latinlover.com";
    String otherUserEmail = "rifensravens@ddd.com";

    @BeforeEach
    void setup(){
        application = new Application();
        createFamilyController = new CreateFamilyController(application);
        addEmailController = new AddEmailController(application);
        addFamilyMemberController = new AddFamilyMemberController(application);
        AddPersonDTO addPersonDTO = new AddPersonDTO(adminEmail,"Tony","12/12/1990",999999999,919999999,"Rua","Porto",69,"4400-265");
        AddPersonDTO otherUserDTO = new AddPersonDTO(otherUserEmail,"Rifens","28/12/1990",999999999,919999999,"Rua","Porto",12,"4444-111");
        CreateFamilyDTO createFamilyDTO = new CreateFamilyDTO("Ze",null);
        createFamilyController.createFamilyAndAdmin(createFamilyDTO,addPersonDTO);
        application.logInAsAdmin();
        addFamilyMemberController.addFamilyMember(otherUserDTO);
    }

    @DisplayName("Successfully add a new email address")
    @Test
    void mustReturnTrueAddEmail() {

        AddEmailDTO addEmailDTO = new AddEmailDTO("tonyze@superlatinlover.com");
        assertTrue(addEmailController.addEmail(addEmailDTO));
    }

    @DisplayName("Unsuccessfully add an email - invalid email")
    @ParameterizedTest
    @ValueSource(strings = {"  ","invalidemail@@gmail.com","tonyze"})
    @NullAndEmptySource
    void mustReturnFalseAddInvalidEmail(String value) {
        AddEmailDTO addEmailDTO = new AddEmailDTO(value);


        assertFalse(addEmailController.addEmail(addEmailDTO));
    }


    @DisplayName("Unsuccessfully add an email - email already registered to user")
    @Test
    void mustReturnFalseAddEmailEmailRegistred() {

        AddEmailDTO addAdminEmailDTO = new AddEmailDTO(adminEmail);
        assertFalse(addEmailController.addEmail(addAdminEmailDTO));
    }


    @DisplayName("Unsuccessfully add an email - email already registered to another user")
    @Test
    void mustReturnFalseAddEmailEmailRegistredAnotherUser() {

        AddEmailDTO addOtherUserEmailDTO = new AddEmailDTO(otherUserEmail);
        assertFalse(addEmailController.addEmail(addOtherUserEmailDTO));
    }

}