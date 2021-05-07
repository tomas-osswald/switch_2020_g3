package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

/*
@SpringBootTest @Tag("Email")
@RunWith(SpringRunner.class)
class AddEmailControllerTest {

    @Mock
    IAddEmailService addEmailService;

    @InjectMocks
    IAddEmailController addEmailController;
    AddEmailDTO addEmailDTO = new AddEmailDTO("admintony@latinlover.com", "tonyZe@latinlover.com");

    @Test
    void addEmailSuccess() {
        Mockito.doNothing().when(addEmailService).addEmail(interEmailDTO);

        boolean result = addEmailController.addEmail(addEmailDTO);
        assertTrue(result);
    }

    @Test
    void addEmailFail() {
        Mockito.doThrow(EmailAlreadyRegisteredException.class).when(addEmailService).addEmail(addEmailDTO);

        boolean result = addEmailController.addEmail(addEmailDTO);
        assertFalse(result);
    }
}
/*
 */