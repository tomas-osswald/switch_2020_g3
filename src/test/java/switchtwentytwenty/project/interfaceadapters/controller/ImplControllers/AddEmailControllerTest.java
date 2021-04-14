package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IAddEmailController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class AddEmailControllerTest {

    @Mock
    IAddEmailService addEmailService;


    @InjectMocks
    AddEmailController addEmailController;
    AddEmailDTO addEmailDTO = new AddEmailDTO("admintony@latinlover.com", "tonyZe@latinlover.com");


    @Test
    void addEmailSuccess() {
        Mockito.doNothing().when(addEmailService).addEmail(addEmailDTO);

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