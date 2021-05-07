package switchtwentytwenty.project.interfaceadapters.controller;

import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IAddEmailController;
import switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.AddFamilyMemberController;
import switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.CreateFamilyController;

class AddEmailControllerTest {


    CreateFamilyController createFamilyController;
    IAddEmailController addEmailController;
    AddFamilyMemberController addFamilyMemberController;
    String adminEmail = "tonyze@latinlover.com";
    String otherUserEmail = "rifensravens@ddd.com";

/*
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


    @DisplayName("Successfully add an email - email already registered to another user as PersonID")
    @Test
    void mustReturnTrueAddEmailEmailRegisteredAsAnotherUserPersonID() {

        AddEmailDTO addOtherUserEmailDTO = new AddEmailDTO(otherUserEmail);
        assertTrue(addEmailController.addEmail(addOtherUserEmailDTO));
    }
*/
}